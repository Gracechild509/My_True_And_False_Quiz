package com.trueandfalse.mytrueandfalsequiz;

public class Questions {

    public String mQuestions[] = {

            " Real Madrid football club’s biggest rival is Atlético Madrid",
            "After you drink alcohol, it takes your brain 6 minutes to start reacting to it",
            "Thomas Jefferson was the second president of the U.S.A.",
            "There is no way of telling boiled eggs from raw eggs until you break them open",
            " Dan Brown’s novel ‘Inferno’ was inspired by Dante Alighieri’s poem ‘Inferno’",
            "Singer Billie Eilish’s full name is Billie Eilish Pirate Baird O’Connell",
            "Manchester United football club has never won the UEFA Champions League trophy",
            " Magician Richard Jones is the 10th winner of the TV show Britain’s got Talent",
            "Mount Fuji is the highest mountain in Japan",
            "Steak contains more protein than a regular-sized broccoli",
            "TV series Game of Thrones – Tyrion Lannister’s favourite quote is ‘I drink, and I know things’",
            "The world’s longest word has no less than 189,819 letters and comes from the English language",
            "Athlete Usain Bolt is faster than a cheetah",
            " Indira Gandhi was the first female Prime Minister of India",
            "The lighter was invented before the matches",
            " The oldest educational establishment in the world is the University of Al Quaraouiyine in Morocco",
            "The first football in the world was manufactured from a pig’s bladder",
            " Although they love to drink it, cats are lactose intolerant to cow’s milk",
            " Rio de Janeiro is the capital city of Brazil",
            " Grapefruit can cause poisoning if consumed with some prescribed drugs",
            " Except for humans, crows and ravens are the most intelligent creatures in the world",
            "The world’s best-selling music album of all times belongs to The Beatles",
            " The spiral shapes of sunflowers follow the Fibonacci sequence (where each number is the sum of the last 2) to maximize sunlight intake",
            " Evita Perón was the first female president of Argentina",
            " A human being can live up to 3 weeks without drinking water",
            " Writer Agatha Christie’s real name is Mary Westmacott",
            " A person’s fingernails and hair continue to grow after they die",
            "It is illegal to feed pigeons in the Italian city of Venice",
            "The Quetzalcóatl Pyramid in Mexico is bigger than the Great Egyptian Pyramid of Giza",
            "Human teeth are just as strong as the teeth of a mature shark",
            "DNA stands for Deoxyribonucleic Acid.",
            "The three primary colours are red, blue, and green.",
            "A typical human has 32 teeth.",
            "Monaco is the smallest country in Europe",
            "The Pacific Ocean is the world’s largest ocean.",
            "There are 88 keys on a standard piano.",
            "Abraham Lincoln was the 16th President of the United States.",
            "The Amazon River is the longest river in the world.",
            "The symbol for the chemical element gold is Gd.",
            "The chemical element with the symbol Hg is Hydrogen.",
            "The human body has 206 bones.",
            "Vitamin C is also known by the chemical name of Ascorbic Acid",
            "The Nobel prize-winning novel ‘The Old Man and the Sea’ was written by the American novelist Ernest Hemingway",
            "The Pan American Highway in the U.S.A. is the world’s longest highway",
            "9. The maximum length for a video posted on TikTok is 60 seconds",
            "Glass is manufactured mainly from processed sand",
            " The liver is the largest organ in the human body",
            "The Pan American Highway in the U.S.A. is the world’s longest highway"


















};

    private String myAnswers[] = {
            "false",
            "true",
            "false",
            "false",
            "true",
            "true",
            "false",
            "true",
            "true",
            "false",
            "true",
            "true",
            "false",
            "true",
            "true",
            "true",
            "true",
            "true",
            "false",
            "true",
            "true",
            "false",
            "true",
            "false",
            "false",
            "true",
            "false",
            "true",
            "true",
            "true",
            "true",
            "false",
            "true",
            "false",
            "true",
            "true",
            "true",
            "false",
            "false",
            "false",
            "true",
            "true",
            "true",
            "true",
            "true",
            "true",
            "false",
            "true"

    };

    public String getQuestion(int number) {
        return mQuestions[number];

    }

    public String getAnswer(int number) {
        return myAnswers[number];
    }
}
