#!/usr/bin/perl

use warnings;
use strict;
use utf8;

binmode STDIN, ":utf8";
binmode STDOUT, ":utf8";

while (<>) {
    s/‘/'/g;
    s/’/'/g;
    s/“/"/g;
    s/”/"/g;
    s/‟/"/g;

    s/…/.../g;
    s/([0-9]+)–([0-9]+)/$1-$2/g;
    s/([0-9]+)—([0-9]+)/$1-$2/g;
    s/([0-9]+)−([0-9]+)/$1-$2/g;
    s/([0-9]+)—([0-9]+)/$1-$2/g;
    s/([0-9]+)‒([0-9]+)/$1-$2/g;


    s/–/ -- /g;
    s/—/ -- /g;
    s/−/ -- /g;
    s/—/ -- /g;
    s/‒/ -- /g;
    s/•/ -- /g;
    s/●/ -- /g;

    s/\x{202F}/ /g;
    s/\x{F0B7}/ /g;
    s/\x{F0A7}/ /g;
    s/\x{F02D}/ /g;
    s/\x{00A0}/ /g;
    s/\x{2002}/ /g;
    s/\x{2003}/ /g;

    # Maths
    s/⁄/\//g;
    s/≥/>=/g;
    s/⫹/<=/g;
    s/→/->/g;
    s/≈/=/g;
    s/⫽/\/\//g;
    s/⫻/\/\/\//g;
    s/⬍/<>/g;
    s/⫺/>=/g;
    s/␳ //g; # not sure
    s/ˇ//g; # dunno what it's used for
    s/冱//g;
    s/␤/ /g;
    s/␣/ /g;
    s/␭//g;
    s/⌬//g;
    s/⌬␹2//g;
#    s/¼/1\/4/g;
    s/¼/ /g; # never an actual quarter
    s/ε/e/g;
    s/φ/p/g;
    s/α/a/g;
    s/β/b/g;
    s/δ/d/g;
    s/χ/x/g;
    s/λ/p/g;
    s/η/h/g;
    
    # Polish
    s/ą/a/g;
    s/ć/c/g;
    s/ę/e/g;
    s/ł/l/g;
    s/ó/o/g;
    s/ń/n/g;
    s/ś/s/g;
    s/ż/z/g;
    s/ź/z/g;
    s/Ć/C/g;
    s/Ą/A/g;
    s/Ę/E/g;
    s/Ł/L/g;
    s/Ó/O/g;
    s/Ń/N/g;
    s/Ś/S/g;
    s/Ż/Z/g;
    s/Ź/Z/g;

    # Turkish
    s/ğ/g/g;
    s/ö/o/g;
    s/ü/u/g;
    s/ş/s/g;
    s/Ö/O/g;
    s/Ç/C/g;
    s/ı/i/g;
    s/ç/c/g;
    s/Ş/S/g;

    # other
    s/š/s/g;
    s/Č/C/g;
    s/č/c/g;
    s/ý/y/g;

    s/  +/ /g;

    print;
}
