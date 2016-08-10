#!/usr/bin/perl

use warnings;
use strict;

my %without = ();
my %with = ();
my %kfnum = ();

my $lang = 'pl';
my $bundle_file = "/tmp/bundles.$lang.tsv.filt.txt";

open(LIST, "<", "/tmp/listing") or die "$!";
open(BUNDLES, "<", $bundle_file) or die "$!";
binmode LIST, ":utf8";
binmode BUNDLES, ":utf8";

open(ALTS, ">", "/tmp/bundle-alternatives.tsv") or die "$!";
binmode ALTS, ":utf8";

my @files = ();
while (<LIST>) {
    chomp;
    my @a = split/\t/;
    push @files, $a[0];
}

my @bundles;
while(<BUNDLES>) {
    my @b = split/\t/;
    $kfnum{$b[0]} = $b[1];
    push @bundles, $b[0];
}

for my $f (@files) {
    next if ($f !~ m!/$lang/!);
    my $file;
    open ($file, "<", $f) or die "$!";
    binmode $file, ":encoding(cp1252)";
    while(<$file>) {
        for my $b (@bundles) {
            my $a = $b;
            $a =~ s/#/[0-9]+/g;
            if (/$a/i) {
                if (exists $with{$b}) {
                    $with{$b}++;
                } else {
                    $with{$b} = 1;
                }
            } else {
                $a =~ s/ /\[-\.,!';\]? */g;
                if (/($a)/i) {
                    print ALTS "$b\t$1\n";
                    if (exists $with{$b}) {
                        $without{$b}++;
                    } else {
                        $without{$b} = 1;
                    }
                }
            }
        }
    }
}

print "BUNDLE\tORIG\tWITH\tWITHOUT\n";
for my $bun (@bundles) {
    print $bun;
    print "\t";
    print $kfnum{$bun};
    print "\t";
    my $with_out = 0;
    if(exists $with{$bun}) {
        $with_out = $with{$bun};
    }
    print $with_out;
    print "\t";
    my $without_out = 0;
    if(exists $without{$bun}) {
        $without_out = $without{$bun};
    }
    print $without_out;
    print "\n";
}
