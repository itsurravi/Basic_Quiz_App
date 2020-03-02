package com.rvsharma.myapplication;

public class Question {

    public String questions[] = {
            "Which is a Programming Language?",
            "In COMAL language program, after name of procedure parameters must be in?",
            "Programming language COBOL works best for use in?",
            "Logarithm tables were invented by?",
            "With which sport is the Jules Rimet trophy associated?",
            "Joule is the unit of?",
            "The headquarter of International Atomic Energy Agency (IAEA) are situated at",
            "The headquarter of 'Assam Rifles' at?",
            "The headquarter of the International court of Justice (UNO) are located at",
            "Which is a reserved word in the Java programming language?",
            "Which is a valid keyword in java?",
            "Who flagged off 'Apiary on Wheels-A concept for Bee Keeping'?",
            "Who has been elected new president of All India Chess Federation?",
            "Who won the FIH Men's Player of the Year award?",
            "India Action Plan 2020 Summit was held in which city?",
            "Which of the following wonAll India Bombay Gold Cup hockey championship?"
    };

    public String choices[][] = {
            {"HTML", "CSS", "Vala", "PHP"},
            {"Punction Marks", "Back-Slash", "Brackets", "Semi Colon"},
            {"Siemens Applications", "Student Applications", "Social Applications", "Commercial Applications"},
            {"John Napier", "John Doe", "John Harrison", "John Douglas"},
            {"Basketball", "Football", "Hockey", "Golf"},
            {"Temperature", "pressure", "energy", "heat"},
            {"Vienna", "Geneva", "Rome", "Parisenergy"},
            {"Shillong", "Kohima", "Aizawl", "Itanagar"},
            {"Hague (Netherlands)", "Addis Ababa", "Bangkok", "New York, USA"},
            {"method", "native", "subclasses", "array"},
            {"interface", "string", "Float", "unsigned"},
            {"Amit Shah", "Rajnath Singh", "Nitin Gadkari", "Piyush Goyal"},
            {"Bharat Singh Chauhan", "Harish Grama", "Ajay Patel", "P R Venketrama Raja"},
            {"Rupinder Pal Singh", "Sreejesh Parattu Raveendran", "Akashdeep Singh", "Manpreet Singh"},
            {"Chennai", "Mumbai", "Kolkata", "New Delhi"},
            {"Indian Navy", "Indian Air Force", "Indian Army", "South Central Railway"},
    };

    public String correctAnswer[] = {
            "PHP",
            "Brackets",
            "Commercial Applications",
            "John Napier",
            "Football",
            "energy",
            "Vienna",
            "Shillong",
            "Hague (Netherlands)",
            "native",
            "interface",
            "Nitin Gadkari",
            "Ajay Patel",
            "Manpreet Singh",
            "New Delhi",
            "Indian Navy"

    };

    public String getQuestion(int a) {
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a) {
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a) {
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a) {
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a) {
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = correctAnswer[a];
        return answer;
    }
}
