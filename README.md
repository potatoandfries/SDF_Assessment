# SDF_Revision

first step:

Make a folder in SDF

git init >> makes a repo in GH (local side) >> check whether the current spot you opened is what you want

go github make one repo(online) 

e.g:
echo "# SDFday04" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:potatoandfries/SDFday04.git
git push -u origin main

how to check? 
git remote -v

then we make  two directories: <one for classes and one for src>
cd C:/Users/orbis/SDF/day??
mkdir classes
mkdir src

make .gitignore by :
code -r .gitignore
(since we are windows )

git status
git add (file name) / or git add -A
git commit -m "blah"
 git push --set-upstream origin main


you wanna add a java file to a specific folder? 
cd to change the directory to the src folder like for eg.
cd C:/USers/orbis/SDF/day06/src
then use code -r <filename>.Java  that sort of thing

// Git will ignore the specified patterns and files. Here's what each of these lines means:

classes: This line will ignore the classes directory in your Git repository. If you have a directory named classes, it won't be tracked by Git.

*.log: This line will ignore all files with the .log extension. Any file with a .log extension will not be tracked by Git.

*.tmp: This line will ignore all files with the .tmp extension. Files with a .tmp extension will not be tracked by Git.

Make sure that your .gitignore file is placed in the root of your Git repository, and Git should start ignoring the specified files and directories that match these patterns. This is useful for excluding build artifacts, log files, temporary files, or any other files or directories you don't want to include in your version control.
//

>> this means directory classes but use all .java files in src 
Ls
javac -d classes src/*.java
javac -d <1.file location for classes> <2.file locatin for .java>
e.g 1. Recursion/classes
e.g 2. Recursion/src/*.java


(it compiles everything with java file)
java -cp classes src/CClient.java

for e.g java -cp Recusion/classes Recursion/src/Recursion.java



