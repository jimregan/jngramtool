#!/usr/bin/perl

use warnings;
use strict;
use utf8;

binmode STDIN, ":utf8";
binmode STDOUT, ":utf8";

open(LIST, "<", "/tmp/listing") or die "$!";
binmode LIST, ":utf8";

my $tlang = 'pl';

while(<LIST>) {
    my $file = '';
    my $name = '';
    my $year = '';
    my $lang = '';
    my $field = '';

    chomp;
    next if ($_ !~ /\/$tlang\//);
    if (/\t/) {
        ($file, $name, $year) = split/\t/;
    } else {
        $file = $_;
        if ($file =~ /\-\d\d\d\d\-/) {
            my @tmp = split/\//, $file;
            my @tmpb = split/\-/, $tmp[$#tmp];
            $name = $tmpb[0];
            $year = $tmpb[1];
        } elsif (/\/([a-z][-a-z]*)(\d\d\d\d)\.txt/) {
            $name = $1;
            $year = $2;
        } else {
            die "Unexpected line: $_\n";
        }
    }
    $name = lc($name);
    my @tmpa = split/\//, $file;
    $field = $tmpa[0];
    $lang = $tmpa[1];
    print "$file\t$name\t$year\n";
}
