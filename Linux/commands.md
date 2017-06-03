
#### grep

Search for the term Pack in the README.md file.

    grep Pack README.md    
    
Search the README.md file for any lines that contain the letter **r** followed by any two characters, then followed by the letter **y**.

    grep "r..y" README.md
    
Count the number of times a pattern is found in a file.

    grep -c ruby README.md

The -n flag will print line numbers as part of the output.

    grep -n Ruby README.md
    
Searches are case sensitive (by default)
case **in**sensitive search instead is done by adding the -i flag.

    grep -i rails README.md

Search multiple files:

    grep rails README.md RELEASING_RAILS.rdoc
     
Search in a specific file:

    grep gem *.rb


Recursively search through directories:

    grep -R "Read" .
    
Search only for the term **Read** in yml files.    

    grep -R --include="*.yml" "Read" .

Copy a directory:

    cp <sourceDir> <targetDir>

Zip a directory:

    zip -r myfiles.zip mydir

Unzip a directory:

    unzip myfiles.zip -d <directoryName>
    
**-d**: allows extraction in an arbitrary directory (always assuming one has permission to write to the directory)
