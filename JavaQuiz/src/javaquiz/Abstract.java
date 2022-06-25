
package javaquiz;

public class Abstract {
    
    protected String questions[] = {
        "What is a correct syntax to output \"Hello World\" in Java?",
        "Which data type is used to create a variable that should store text?",
        "How do you create a variable with the numeric value 5?",
        "How do you create a variable with the floating number 2.8?",
        "Which method can be used to find the length of a string?",
        "Which operator is used to add together two values?",
        "Which method can be used to return a string in upper case letters?",
        "To declare an array in Java, define the variable type with:",
        "How do you call a method in Java?",
        "Which keyword is used to create a class in Java?"};
    protected String options[][] = {
        {"Console.WriteLine(\"Hello World\");", "System.out.println(\"Hello World\");", "echo(\"Hello World\");", "print(\"Hello World\");"},
        {"String", "string", "myString", "Txt"},
        {"float x = 5;", "num x = 5", "x = 5;", "int x = 5;"},
        {"x = 2.8;", "float x = 2.8f;", "int x = 2.8f;", "byte x = 2.8f;"},
        {"getSize()", "len()", "length()", "getLength()"},
        {"The + sign", "The & sign", "The * sign", "The % sign"},
        {"upperCase()", "touppercase()", "tuc()", "toUpperCase()"},
        {"{}", "()", "[]", "\"\""},
        {"methodName();", "(methodName);", "(methodName;", "(methodName[];"},
        {"className", "MyClass", "class()", "class"},};

    protected char rightAnswers[] = {'b', 'a', 'd', 'b', 'c', 'a', 'd', 'c', 'a', 'd'};
}
