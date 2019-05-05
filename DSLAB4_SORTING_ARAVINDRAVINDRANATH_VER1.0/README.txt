Project by Aravind Ravindranath

The source code was developed in JAVA 1.8. It was developed using Eclipse Neon.
Eclipse IDE details ( Version: Neon.3 Release (4.6.3)
					  Build id: 20170314-1500 )

To run the program, enter:  java com.jhu.ds.lab2.IOoperations.ProcessInputSquareMatrices
							[Input File Name] [Output File Name].

The first two Strings in the square brackets depict the two arguments which should be passed when
the above program is executed. The file path is relative to the project folder and inputFile 
should be clearly specified. If there is a folder Input  under the project folder in which the 
input file LabInput1 is kept, then the command line should have ../Input/LabInput1 when 
executed from folder bin.If executed in an IDE like eclipse, then 
/Input/LabInput1 shall work. The output file contains sorted integer data along with the runtime in 
microseconds. The file path or the file names are not hard coded. The output file name is used to 
generate files corresponding to the sort type used. For example, take an input file ran50.dat, 
denoting a file with 50 randomly ordered integers, we can name the output file as ran50output. The call
is made as below:

ProcessInputFile input/ran50.dat output/ran50out

After program run 7 output files: ran50outputheapSort, ran50outputshellSortGap0, ran50outputshellSortGap1, 
ran50outputshellSortGap2, ran50outputshellSortGap3, ran50outputshellSortGap4 and ran50outputinsSort
are generated. Shell Sort algorithm is run with 5 Gap Sequences.


Analysis document is provided in the Analysis Folder along with an additional document which lists the 
measurement of the sorting algorithms on all the files in the input folder.