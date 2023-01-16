def read_file():
    gradesFile = open("c:\Users\User\Desktop\Software Dev\Python Tasks\Grades\grades.txt","r") 
    contents = gradesFile.read()  
    
    print(contents)

    gradesFile.close()

read_file()