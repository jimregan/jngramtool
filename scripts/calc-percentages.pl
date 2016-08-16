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
    "(V/A)+to type 9" => "VP",
);

my %nbundles = ();
my %nnbundles = ();

my %cat_totals_n = ();
my %cat_totals_nn = ();

my %raw_cat = ();

open(NATIVE, "<", $ARGV[0]) or die "$!";
open(NONNATIVE, "<", $ARGV[1]) or die "$!";
open(OUT, ">", "bundle-comparison.tsv") or die "$!";
binmode NATIVE, ":utf8";
binmode NONNATIVE, ":utf8";
binmode OUT, ":utf8";
open(BOUT, ">", "broad-comparison.tsv") or die "$!";
binmode BOUT, ":utf8";


my $token_total_n = 0;
my $token_total_nn = 0;

my %broad_n = ();
my %broad_nn = ();
my %narrow_n = ();
my %narrow_nn = ();

while(<NATIVE>) {
    chomp;
    my @l = split/\t/;
    $nbundles{$l[0]} = $l[1];
    $token_total_n += $l[1];
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
}

while(<NONNATIVE>) {
    chomp;
    my @l = split/\t/;
    $nnbundles{$l[0]} = $l[1];
    $token_total_nn += $l[1];
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
}

my %both = ();

my @singleton = ();
my %npct = ();
for my $nb (keys %nbundles) {
    my $pct = ($nbundles{$nb} * 1.0) / $token_total_n * 100;
    $npct{$nb} = $pct;
    my $raw = $raw_cat{$nb};
    if(!exists $nnbundles{$nb}) {
        push @singleton, "$nb\t$nbundles{$nb}\t$npct{$nb}\t-\t-\t-\t$raw_cat{$nb}\t$catmap{$raw}\n";
    }
}
print OUT "BUNDLE\tNATIVE COUNT\tNATIVE %\tNON-NATIVE COUNT\tNON-NATIVE %\tDIFFERENCE %\tCATEGORY\tBROAD\n";

for my $b (keys %nnbundles) {
    my $pct = ($nnbundles{$b} * 1.0) / $token_total_nn * 100;
    my $raw = $raw_cat{$b};
    if(!exists $nbundles{$b}) {
        push @singleton, "$b\t-\t-\t$nnbundles{$b}\t$pct\t-\t$raw_cat{$b}\t$catmap{$raw}\n";
    } else {
        my $diff = $npct{$b} - $pct;
        print OUT "$b\t$nbundles{$b}\t$npct{$b}\t$nnbundles{$b}\t$pct\t$diff\t$raw_cat{$b}\t$catmap{$raw}\n";
    }
}

for my $s (@singleton) {
    print OUT $s;
}

for my $m (keys %broad_n) {
    my $npct = ($broad_n{$m} * 1.0) / $token_total_n * 100;
    if(exists $broad_nn{$m}) {
        my $nnpct = ($broad_nn{$m} * 1.0) / $token_total_nn * 100;
        print BOUT "$m\t$broad_n{$m}\t$broad_nn{$m}\n";
    } else {
        print BOUT "$m\t$broad_n{$m}\n";
    }
}
