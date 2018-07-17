/**
 * Student Name: Nimun Bajwa
 * Teacher: Mr. Qureshi
 * FINAL EXAM PROJECT
 * Math Game
 */
import java.util.Scanner;

public class tri6 {

    Double age;
    Double agesenter;
    Boolean validage;

    public static void main(String[] args) {
        intro();
    }

    public static void intro() {
        double age;
        String name;
        //points from the addition questions
        int addpoints;
        //points from the subtraction questions
        int subpoints;
        //points from the multiplication questions
        int multipoints;
        //points from the division questions
        int divipoints;
        //total points 
        int tot;
        Boolean valage;

        Scanner input = new Scanner(System.in);
        double agesenter;
        
        //getting a valid age from the user
        agesenter = getage();

        System.out.println("Enter your name: ");
        name = input.next();

        System.out.println("Hello, " + name + ". This is a game where you see how smart you are, for your age. If you want to quit, type 999, but beware: your total correct points will NOT be displayed. \n You will be given addition and questions first. If you get all of them right, you will advance to multiplication and division. \n There are 5 questions for each operation and you will be given 3 chances to correctly answer. \n Correct Answer on 1st Try: 5 pts \n Correct Answer on 2nd Try: 3 pts \n Correct Answer on 3rd Try: 1 pt");

        //will display addition questions
        addpoints = Addition();
        System.out.println("You have " + addpoints + " points");

        //will display subtraction questions
        subpoints = Subtraction();
        tot = addpoints + subpoints;
        System.out.println("You have " + tot + " points");

        if ((tot) == 50) {
            //user only advances to multiplication and division questions if they got all addition and subtraction questions correct.
            multipoints = Multiplication();
            tot = tot + multipoints;
            System.out.println("You have " + tot + " points");

            divipoints = Division();
            tot = tot + divipoints;
            //total points from all the questions

        }
        //will display total points and how smart user is
        conclusion(tot, agesenter, name);

    }

    public static Double getage() {
        Scanner input = new Scanner(System.in);
        double age;

        //asking for age
        System.out.println("Enter your age: ");
        age = input.nextDouble();
        //checking if age is valid
        agecheck(age);

        return age;
    }

    public static Double agecheck(double age) {
        //checking to see if the input is valid
        if (age <= 3 && age >= 0) {
            System.out.println("I don't think you can use a computer at your age. Try again.");
            getage();
        } else if (age < 0) {
            System.out.println("Are you still in the womb? Try again after being born.");
            getage();
        } else if (age > 122) {
            System.out.println("First get a guinness world record for being the oldest person alive. Then come back.");
            getage();
        }

        return age;
    }

    public static void conclusion(int tot, double agesenter, String name) {
        Scanner input = new Scanner(System.in);
        String playagain;
        System.out.println("You have " + tot + " points by the end of this game. You got " + tot + "%, " + name + "." + "\n");
        //giving statement comparing performance to age
        if (agesenter > 3 && agesenter <= 12) {
            if (tot <= 25) {
                System.out.println("You didn't do too bad for your age, keep it up!");
            } else if (tot <= 50 && tot > 25) {
                System.out.println("WOAH! I wouldn't expect someone that small to have a brain that big!!");
            } else if (tot <= 75 && tot > 50) {
                System.out.println("YOU. ARE. TALENTED. KEEP. IT. UP!!!");
            } else if (tot <= 100 && tot > 75) {
                System.out.println("YOU NEED TO START LEARNING CALCULUS NOW!!!!");
            }
        }

        if (agesenter > 12 && agesenter <= 15) {
            if (tot <= 25) {
                System.out.println("You need to study. Desperately.");
            } else if (tot <= 50 && tot > 25) {
                System.out.println("Maybe practice some math!");
            } else if (tot <= 75 && tot > 50) {
                System.out.println("Pretty good!");
            } else if (tot <= 100 && tot > 75) {
                System.out.println("GOOD JOB. YOU HAVE A BRIGHT FUTURE.");
            }
        }

        if (agesenter > 15) {
            if (tot <= 25) {
                System.out.println("You have no math skills. Go on KhanAcademy.");
            } else if (tot <= 50 && tot > 25) {
                System.out.println("I would expect you to do better");
            } else if (tot <= 75 && tot > 50) {
                System.out.println("Pretty good, but you could do WAY better for your age!");
            } else if (tot <= 100 && tot > 75) {
                System.out.println("YOU ARE AMAZING.");
            }
        }

        System.out.println("Would you like to play again? Enter 'Y' for Yes or any other key for No.");
        playagain = input.nextLine();
        if ((playagain == "Y") || (playagain == "y")) {
            intro();
        } else if ((playagain == "N") || (playagain == "n")) {
            System.out.println("Program terminated");
            //making program end
            System.exit(0);
        }

    }

    public static int Addition() {
        Scanner input = new Scanner(System.in);
        int x;
        int y;
        int ans;
        int uin;
        int i;
        int addpoints = 0;
        int j = 0;
        
        //generating 5 questions
        for (j = 1; j <= 5; j++) {

            x = (int) (Math.random() * 20) + 0;
            y = (int) (Math.random() * 20) + 0;

            ans = x + y;
            System.out.println(x + "+" + y + "= ?");
            uin = input.nextInt();
            
            
            //allowing for 3 trials
            for (i = 1; i <= 3; i++) {
                if (uin == 999) {
                    System.out.println("Program has been terminated. You aren't brave enough to tread on the journey to intelligence.");
                    System.exit(0);
                }

                if (i == 1) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 5 points.");
                        addpoints = addpoints + 5;
                        break;
                    } else {
                        System.out.println("You are wrong. Try again");
                        uin = input.nextInt();

                    }

                } else if (i == 2) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 3 points.");
                        addpoints = addpoints + 3;
                        break;
                    } else {
                        System.out.println("You are wrong. Try again");
                        uin = input.nextInt();

                    }
                } else if (i == 3) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 1 point.");
                        addpoints = addpoints + 1;
                        break;
                    } else {
                        System.out.println("You are wrong. 0 Points. Enter any number to try the next question.");
                        uin = input.nextInt();

                    }
                }
            }

        }
        //returning points from addition questions
        return addpoints;
    }

    public static int Subtraction() {
        Scanner input = new Scanner(System.in);
        int x;
        int y;
        int ans;
        int uin;
        int i;
        int subpoints = 0;
        int j = 0;

        //generating 5 questions
        for (j = 1; j <= 5; j++) {

            x = (int) (Math.random() * 20) + 0;
            //ensuring the answer won't be a negative number.
            y = (int) (Math.random() * x) + 0;

            ans = x - y;
            System.out.println(x + "-" + y + "= ?");
            uin = input.nextInt();

            //allowing for 3 trials
            for (i = 1; i <= 3; i++) {
                if (uin == 999) {
                    System.out.println("Program has been terminated");
                    System.exit(0);
                }

                if (i == 1) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 5 points.");
                        subpoints = subpoints + 5;
                        break;
                    } else {
                        System.out.println("You are wrong. Try again");
                        uin = input.nextInt();

                    }

                } else if (i == 2) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 3 points.");
                        subpoints = subpoints + 3;
                        break;
                    } else {
                        System.out.println("You are wrong. Try again");
                        uin = input.nextInt();

                    }
                } else if (i == 3) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 1 point.");
                        subpoints = subpoints + 1;
                        break;
                    } else {
                        System.out.println("You are wrong. 0 Points. Try the next question.");
                        uin = input.nextInt();

                    }
                }
            }

        }
        //returning points from subtraction questions
        return subpoints;
    }

    public static int Multiplication() {
        Scanner input = new Scanner(System.in);
        int x;
        int y;
        int ans;
        int uin;
        int i;
        int multipoints = 0;
        int j = 0;

        //generating 5 questions
        for (j = 1; j <= 5; j++) {

            x = (int) (Math.random() * 20) + 0;
            y = (int) (Math.random() * 20) + 0;

            ans = x * y;
            System.out.println(x + "x" + y + "= ?");
            uin = input.nextInt();

            //allowing for 3 trials
            for (i = 1; i <= 3; i++) {
                if (uin == 999) {
                    System.out.println("Program has been terminated");
                    System.exit(0);
                }

                if (i == 1) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 5 points.");
                        multipoints = multipoints + 5;
                        break;
                    } else {
                        System.out.println("You are wrong. Try again");
                        uin = input.nextInt();

                    }

                } else if (i == 2) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 3 points.");
                        multipoints = multipoints + 3;
                        break;
                    } else {
                        System.out.println("You are wrong. Try again");
                        uin = input.nextInt();

                    }
                } else if (i == 3) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 1 point.");
                        multipoints = multipoints + 1;
                        break;
                    } else {
                        System.out.println("You are wrong. 0 Points. Try the next question.");
                        uin = input.nextInt();

                    }
                }
            }

        }
        //returning points from multiplication questions
        return multipoints;
    }

    public static int Division() {
        Scanner input = new Scanner(System.in);
        int x;
        int y;
        int ans;
        int uin;
        int i;
        int divipoints = 0;
        int j = 0;

        //generating 5 questions
        for (j = 1; j <= 5; j++) {

            do {
                x = (int) (Math.random() * 20) + 0;
                //denominator can't be 0 because that is undefined and the denominator should be less than the numerator.
                y = (int) (Math.random() * x) + 1;
            } while (x % y != 0);

            ans = x / y;
            System.out.println(x + "÷" + y + "= ?");
            uin = input.nextInt();
            
            //allowing for 3 trials
            for (i = 1; i <= 3; i++) {
                if (uin == 999) {
                    System.out.println("Program has been terminated");
                    System.exit(0);
                }

                if (i == 1) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 5 points.");
                        divipoints = divipoints + 5;
                        break;
                    } else {
                        System.out.println("You are wrong. Try again");
                        uin = input.nextInt();

                    }

                } else if (i == 2) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 3 points.");
                        divipoints = divipoints + 3;
                        break;
                    } else {
                        System.out.println("You are wrong. Try again");
                        uin = input.nextInt();

                    }
                } else if (i == 3) {
                    if (uin == ans) {
                        System.out.println("You are correct. You gain 1 point.");
                        divipoints = divipoints + 1;
                        break;
                    } else {
                        System.out.println("You are wrong. 0 Points. Try the next question.");
                        uin = input.nextInt();

                    }
                }
            }

        }
        //returning points from division questions
        return divipoints;
    }

}
