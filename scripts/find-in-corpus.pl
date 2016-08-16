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

my %exp = ();

while(<BUNDLES>) {
    my @l = split/\t/;
    push @bundles, $l[0];
    $exp{$l[0]} = $l[1];
}

my %det = ();

while(<LIST>) {
    chomp;
    my @l = split/\t/;
    push @files, $l[0];
    $det{$l[0]} = $l[1] . ", " . $l[2];
}

print OUT "<html>\n";
print OUT "<head>\n";
print OUT "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\n";
print OUT "</head>\n";
print OUT "<body>\n";

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

            if(/(^$b\b|\b$b\b|\b$b$)/i) {
                my $m = $1;
                my $s = $_;
                next if($s =~ /$b'/);
                $total += () = $s =~ s!$m!<b>$m</b>!g;
                print OUT "<p>$s</p>\n";
                print OUT "<p>(<i>$f</i>, $det{$f})</p>\n";
            }
        }
    }
    print OUT "<p>Total: $total (expected: $exp{$b})</p>\n";
}
print OUT "</body>\n";
print OUT "</html>\n";
