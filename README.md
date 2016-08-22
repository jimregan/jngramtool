# jngramtool

This package is aimed at linguistic uses of ngrams. Among the tasks it performs are n-gram reduction (removing lower order n-grams that are completely contained by higher order n-grams); extraction of lexical bundles (in this case, n-grams that do not span punctuation boundaries) from a corpus, while retaining information about author, field, and year, for further restriction. The package contains a partial clone of kfNgram.

jngramtool was originally created as part of a tool to create Google n-gram style data from the Nation Corpus of Irish (available in the package NCIReader). As many of the components proved useful for other tasks, they have been extracted into this package.
