#!/usr/bin/perl

use warnings;
use strict;
use utf8;

binmode STDIN, ":utf8";
binmode STDOUT, ":utf8";

my %bcnt = ();
my %bareas = ();
my %bareacnt = ();
my %bauths = ();
my %bauthcnt = ();


while(<>) {
    chomp;
    my ($b, $f, $l, $y, $a, $n) = split/\t/;
    if (exists $bcnt{$b}) {
        $bcnt{$b} += $f;
    } else {
        $bcnt{$b} = $f;
    }

    my $bauthk = $b . '___' . $n;
    if (exists $bauths{$bauthk}) {
        if (exists $bauthcnt{$b}) {
            $bauthcnt{$b}++;
        } else {
            $bauthcnt{$b} = 1;
        }
    } else {
        $bauths{$bauthk} = 1;
        $bauthcnt{$b} = 1;
    }

    my $bareak = $b . '___' . $a;
    if (exists $bareas{$bareak}) {
        if (exists $bareacnt{$b}) {
            $bareacnt{$b}++;
        } else {
            $bareacnt{$b} = 1;
        }
    } else {
        $bareas{$bareak} = 1;
        $bareacnt{$b} = 1;
    }

}

for my $k (keys %bcnt) {
    print "$k\t" . $bcnt{$k} . "\t" . $bauthcnt{$k} . "\t" . $bareacnt{$k} . "\n";
}
