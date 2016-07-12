package ie.tcd.slscs.ngramtool;

import static org.kohsuke.args4j.ExampleMode.ALL;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.BooleanOptionHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class StringReductionMain {
    @Option(name="-from", usage="input stream encoding")
    private String inputEncoding;

    @Option(name="-to", usage="output stream encoding")
    private String outputEncoding;

    @Option(name="-output", usage="output file")
    private String outputFileName;

    @Option(name="-algorithm", usage="reduction algorithm number")
    private int Algorithm = 2;

    @Option(name="-char", usage="use character n-grams (default is word n-grams)")
    private boolean character = false;

    @Option(name="-sort", usage="sort output")
    private boolean sorted = false;

    @Option(name="-freq", usage="frequency threshold for algorithms 1, 2 & 4")
    private int threshold = 1;

    @Option(name="-m", usage="minimum size of n-gram for algorithm 4")
    private int arity = 1;

}
