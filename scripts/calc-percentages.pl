#!/usr/bin/perl


use warnings;
use strict;
use utf8;

binmode STDIN, ":utf8";
binmode STDOUT, ":utf8";

my %catmap = (
    "!!other PP" => "PP",
    "(V/A)+to-clause" => "VP",
    "NP+of" => "NP",
    "PP+of" => "PP",
    "anticipatory it" => "VP",
    "copula be" => "VP",
    "other NP" => "NP",
    "other PP" => "PP",
    "other expression" => "other",
    "passive verb + PP" => "VP",
    "!!adverbial clause" => "Adv",
    "adverbial clause" => "Adv",
    "(V/A)+to type 9" => "VP",
);

my %nbundles = ();
my %nnbundles = ();

my %cat_totals_n = ();
my %cat_totals_nn = ();

my %raw_cat = ();

my %typemap_n = ();
my %typemap_nn = ();
my %typecnt_n = ();
my %typecnt_nn = ();
my %typeocc_n = ();
my %typeocc_nn = ();

open(NATIVE, "<", $ARGV[0]) or die "$!";
open(NONNATIVE, "<", $ARGV[1]) or die "$!";
open(OUT, ">", "bundle-comparison.tsv") or die "$!";
binmode NATIVE, ":utf8";
binmode NONNATIVE, ":utf8";
binmode OUT, ":utf8";
open(BOUT, ">", "broad-comparison.tsv") or die "$!";
binmode BOUT, ":utf8";
open(NOUT, ">", "narrow-comparison.tsv") or die "$!";
binmode NOUT, ":utf8";


my $token_total_n = 0;
my $token_total_nn = 0;
my $type_total_n = 0;
my $type_total_nn = 0;

my %broad_n = ();
my %broad_nn = ();
my %narrow_n = ();
my %narrow_nn = ();

while(<NATIVE>) {
    chomp;
    my @l = split/\t/;
    $nbundles{$l[0]} = $l[1];
    $token_total_n += $l[1];
    $type_total_n++;
    $raw_cat{$l[0]} = $l[5];
    my $mapping = $catmap{$l[5]};
    if (!exists $cat_totals_n{$mapping}) {
        $cat_totals_n{$mapping} = $l[1];
    } else {
        $cat_totals_n{$mapping} += $l[1];
    }
    if (!exists $broad_n{$mapping}) {
        $broad_n{$mapping} = $l[1];
    } else {
        $broad_n{$mapping} += $l[1];
    }
    if (!exists $narrow_n{$l[5]}) {
        $narrow_n{$l[5]} = $l[1];
    } else {
        $narrow_n{$l[5]} += $l[1];
    }
    $typemap_n{$l[0]} = $l[5];
    if (!exists $typeocc_n{$l[5]}) {
        $typeocc_n{$l[5]} = $l[1];
    } else {
        $typeocc_n{$l[5]} += $l[1];
    }
    if (!exists $typecnt_n{$l[5]}) {
        $typecnt_n{$l[5]} = 1;
    } else {
        $typecnt_n{$l[5]}++;
    }
}

while(<NONNATIVE>) {
    chomp;
    my @l = split/\t/;
    $nnbundles{$l[0]} = $l[1];
    $token_total_nn += $l[1];
    $type_total_nn++;
    $raw_cat{$l[0]} = $l[5];
    my $mapping = $catmap{$l[5]};
    if (!exists $cat_totals_nn{$mapping}) {
        $cat_totals_nn{$mapping} = $l[1];
    } else {
        $cat_totals_nn{$mapping} += $l[1];
    }
    if (!exists $broad_nn{$mapping}) {
        $broad_nn{$mapping} = $l[1];
    } else {
        $broad_nn{$mapping} += $l[1];
    }
    if (!exists $narrow_nn{$l[5]}) {
        $narrow_nn{$l[5]} = $l[1];
    } else {
        $narrow_nn{$l[5]} += $l[1];
    }
    $typemap_nn{$l[0]} = $l[5];
    if (!exists $typeocc_nn{$l[5]}) {
        $typeocc_nn{$l[5]} = $l[1];
    } else {
        $typeocc_nn{$l[5]} += $l[1];
    }
    if (!exists $typecnt_nn{$l[5]}) {
        $typecnt_nn{$l[5]} = 1;
    } else {
        $typecnt_nn{$l[5]}++;
    }
}

my %both = ();

my @singleton = ();
my %npct = ();
my %ncpct = ();
for my $nb (keys %nbundles) {
    my $pct = ($nbundles{$nb} * 1.0) / $token_total_n * 100;
    my $cat = $typemap_n{$nb};
    my $napct = ($nbundles{$nb} * 1.0) / $typeocc_n{$cat} * 100;
    $npct{$nb} = $pct;
    $ncpct{$nb} = $napct;
    my $raw = $raw_cat{$nb};
    if(!exists $nnbundles{$nb}) {
        push @singleton, "$nb\t$nbundles{$nb}\t$npct{$nb}\t$napct\t-\t-\t-\t-\t$raw_cat{$nb}\t$catmap{$raw}\n";
    }
}
print OUT "BUNDLE\tNATIVE COUNT\tNATIVE %\tCATEGORY %\tNON-NATIVE COUNT\tNON-NATIVE %\tCATEGORY %\tDIFFERENCE %\tCATEGORY\n";

for my $b (keys %nnbundles) {
    my $pct = ($nnbundles{$b} * 1.0) / $token_total_nn * 100;
    my $cat = $typemap_nn{$b};
    my $napct = ($nnbundles{$b} * 1.0) / $typeocc_nn{$cat} * 100;
    my $raw = $raw_cat{$b};
    if(!exists $nbundles{$b}) {
        push @singleton, "$b\t-\t-\t-\t$nnbundles{$b}\t$pct\t$napct\t$raw_cat{$b}\t$catmap{$raw}\n";
    } else {
        my $diff = $npct{$b} - $pct;
        print OUT "$b\t$nbundles{$b}\t$npct{$b}\t$ncpct{$b}\t$nnbundles{$b}\t$pct\t$napct\t$diff\t$raw_cat{$b}\t$catmap{$raw}\n";
    }
}

for my $s (@singleton) {
    print OUT $s;
}

print BOUT "BROAD\tNative Count\tPercent\tNon-native Count\tPercent\n";
for my $m (keys %broad_n) {
    my $npct = ($broad_n{$m} * 1.0) / $type_total_n * 100;
    if(exists $broad_nn{$m}) {
        my $nnpct = ($broad_nn{$m} * 1.0) / $type_total_nn * 100;
        print BOUT "$m\t$broad_n{$m}\t$npct\t$broad_nn{$m}\t$nnpct\n";
    } else {
        print BOUT "$m\t$broad_n{$m}\t$npct\n";
    }
}

print NOUT "\tNATIVE COUNT\tNATIVE %\tNON-NATIVE COUNT\tNON-NATIVE %\n";
for my $nar (keys %typecnt_n) {
    my $perc = ($typecnt_n{$nar} * 1.0) / $type_total_n * 100;
    print NOUT "$nar\t$typecnt_n{$nar}\t$perc\t";
    if(exists $typecnt_nn{$nar}) {
        my $percnn = ($typecnt_nn{$nar} * 1.0) / $type_total_nn * 100;
        print NOUT "$typecnt_nn{$nar}\t$percnn\n";
    } else {
        print NOUT "-\t-\n";
    }
}

for my $nn (keys %typecnt_nn) {
    if (!exists $typecnt_n{$nn}) {
        my $percnn = ($typecnt_nn{$nn} * 1.0) / $type_total_nn * 100;
        print NOUT "$nn\t-\t-\t$typecnt_nn{$nn}\t$percnn\n";
    }
}
