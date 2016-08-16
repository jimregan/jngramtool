#!/usr/bin/perl


use warnings;
use strict;
use utf8;

binmode STDIN, ":utf8";
binmode STDOUT, ":utf8";

open(LIST, "<", $ARGV[0]) or die "$!";
open(BUNDLES, "<", $ARGV[1]) or die "$!";
open(OUT, ">", "output.txt") or die "$!";
binmode LIST, ":utf8";
binmode BUNDLES, ":utf8";
binmode OUT, ":utf8";

my @files = ();
my @bundles = ();

while(<BUNDLES>) {
    my @l = split/\t/;
    push @bundles, $l[0];
}

while(<LIST>) {
    my @l = split/\t/;
    push @files, $l[0];
}

for my $b (@bundles) {
    my $total = 0;
    print OUT "\n\n<h3>$b</h3>\n";

    for my $f (@files) {
        open(my $file, "<", "$f.sent") or die "$!";
        binmode $file, ":utf8";
        while(<$file>) {
            chomp;
            s/\x{202F}/ /g;
            s/\x{F0B7}/ /g;
            s/\x{F0A7}/ /g;
            s/\x{F02D}/ /g;
            s/\x{00A0}/ /g;
            s/\x{2002}/ /g;
            s/\x{2003}/ /g;

            s/‘/'/g;
            s/’/'/g;
            s/“/"/g;
            s/”/"/g;
            s/‟/"/g;

            s/–/-/g;
            s/—/-/g;
            s/−/-/g;
            s/—/-/g;
            s/‒/-/g;

            if(/(^$b\b|\b$b\b|\b$b$)/i) {
                my $m = $1;
                my $s = $_;
                $s =~ s!$m!<b>$m</b>!;
                print OUT "<p>$s</p>\n";
                $total++;
            }
        }
    }
    print OUT "<p>Total: $total</p>\n";
}
