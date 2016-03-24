import java.util.Iterator;
import java.util.LinkedList;


    public class Game {
        private ServerThread[] st = new ServerThread[2];
        /**
         * state
         * 0 - game is not started
         * 1 - 1st player move
         * 2 - 2nd player move
         * 3 - word arguing player 2
         * 4 - word arguing player 1
         * 5 - 2nd surrendered
         * 6 - 1st surrendered
         * 7 - game over or someone surrended
         */
        private String word;
        private LinkedList<String> saidWords;
        private int state;
        private int playsFirst;
        private int[] score = {0, 0};
        private Iterator i;
        private boolean isTold = false;


        public Game(ServerThread st1, ServerThread st2) {
            st[0] = st1;
            st[1] = st2;
            state = 0;
            saidWords = new LinkedList<String>();
            i = saidWords.iterator();
        }


        public int getState(){return state;}

        public ServerThread[] getServerThreads(){return this.st;}

        public String getWord(){return this.word;}

        public LinkedList<String> getSaidWords(){return this.saidWords;}

        public void startGame(int p, String word) {
            this.word = word.replace(" ", "");
            StringBuilder sb = new StringBuilder(this.word);
            for (int index = 0; index < sb.length(); index++) {
                char c = sb.charAt(index);
                if (Character.isUpperCase(c)) {
                    sb.setCharAt(index, Character.toLowerCase(c));
                }
            }
            this.word = sb.toString();
            for (int i = 0; i < 2; i++)
                st[i].sendMessage("Game is on! Your word is " + this.word);
            //System.out.println("Word is " + this.word);
            state = p + 1;
            playsFirst = p;
            score[0] = 0;
            score[1] = 0;
        }

        public void sayWord(int p, String word) {
            word = word.replace(" ", "");
            StringBuilder sb = new StringBuilder(word);
            for (int index = 0; index < sb.length(); index++) {
                char c = sb.charAt(index);
                if (Character.isUpperCase(c)) {
                    sb.setCharAt(index, Character.toLowerCase(c));
                }
            }
            word = sb.toString();
            //System.out.println("Player " + p + " is saying word");
            i = saidWords.iterator();
            if (isAnagram(this.word, word)) {
                while (i.hasNext() && !saidWords.isEmpty()) {
                    if (i.next().equals(word)) {
                        st[p].sendMessage("This word has already been told");
                        isTold = true;
                        break;
                    }
                }
                if (!isTold) {
                    for (int i = 0; i < 2; i++)
                        st[i].sendMessage("Player's " + p + " word: " + word);
                    score[p] += 1;
                    saidWords.add(word);
                    if (state == 1 || state == 2)
                        state = state == 1 ? 2 : 1;
                    else if (state == 3 || state == 4)
                        state = state == 3 ? 2 : 1;
                    isTold = false;
                }
            } else {
                st[p].sendMessage("Your word isn't an anagramm, try  again");
                state = state == 1 ? 1 : 2;
            }

            //playsFirst = 1 - p;
        }

        public void lose(int p) {
            st[p].sendMessage("You want to end the game");
            st[1 - p].sendMessage("Player " + p + " wants to end the game. Agree? (/yes, /no)");
            state = state == 1 ? 6 : 5;
        }

        public void getTurn(int player, String message) {
            //���, ��� ��������������� ������ ��� ������ - �����������
        /*System.out.println("Player " + player + " sent " + message + "; state=" + state + " playsFirst=" + playsFirst);
        i = saidWords.iterator();
        System.out.print("Said words:");
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
        System.out.println("Score " + score[0] + " " + score[1]);
        */
            for (int i = 0; i < 2; i++)
                st[i].sendMessage("Score " + score[0] + " " + score[1]);
            switch (state) {
                case 0:
                    if (message.startsWith("/start ")) {
                        startGame(player, message.substring(7));
                    } else
                        st[1 - player].sendMessage(player, message);
                    break;
                case 1:
                    if (message.equals("/end") && player == playsFirst) {
                        lose(player);
                    } else if (message.startsWith("/w ") && player == playsFirst) {
                        sayWord(player, message.substring(3));
                    } else if (message.equals("/a") && player == playsFirst) {
                        state = 4;
                        st[1 - player].sendMessage("Player " + player + " says that your word is incorrect");
                    } else if (message.equals("/surr")) {
                        state = 7;
                        st[1 - player].sendMessage("You won");
                        st[player].sendMessage("You lost");
                    } else
                        st[1 - player].sendMessage(player, message);
                    break;
                case 2:
                    if (message.equals("/end") && player == 1 - playsFirst) {
                        lose(player);
                    } else if (message.startsWith("/w ") && player == 1 - playsFirst) {
                        sayWord(player, message.substring(3));
                    } else if (message.equals("/a") && player == 1 - playsFirst) {
                        state = 3;
                        st[1 - player].sendMessage("Player " + player + " says that your word is incorrect");
                    } else if (message.equals("/surr")) {
                        state = 7;
                        st[1 - player].sendMessage("You won");
                        st[player].sendMessage("You lost");
                    } else
                        st[1 - player].sendMessage(player, message);
                    break;
                case 3:
                    if (message.startsWith("/w ") && player == playsFirst) {
                        score[0] -= 1;
                        saidWords.pop();
                        sayWord(player, message.substring(3));
                    } else if (message.equals("/d")) {
                        state = 2;
                        st[1 - player].sendMessage("Player " + player + " disagrees");
                    }
                    break;
                case 4:
                    if (message.startsWith("/w ") && player == 1 - playsFirst) {
                        score[1] -= 1;
                        saidWords.pop();
                        sayWord(player, message.substring(3));
                    } else if (message.equals("/d")) {
                        state = 1;
                        st[1 - player].sendMessage("Player " + player + " disagrees");
                    }
                    break;
                case 5:
                    if (message.equals("/yes") && player == playsFirst){
                        if (score[0] > score[1]) {
                            st[1 - player].sendMessage("You lose");
                            st[player].sendMessage("You won");
                            state = 7;
                        }
                    }
                    else if (message.equals("/no") && player == playsFirst) {
                        state = 1;
                        st[1 - player].sendMessage("Player " + player + " disagreed");
                    }
                    break;
                case 6:
                    if (message.equals("/yes") && player == 1 - playsFirst) {
                        if (score[0] <= score[1]) {
                            st[1 - player].sendMessage("You won");
                            st[player].sendMessage("You lose");
                            state = 7;
                        }
                    }
                    else if (message.equals("/no") && player == 1 - playsFirst) {
                        state = 2;
                        st[1 - player].sendMessage("Player " + player + " disagreed");
                    }
                    break;
                case 7:
                    if (message.startsWith("/start ")) {
                        startGame(player, message.substring(7));
                    } else
                        st[1 - player].sendMessage(player, message);
            }
        }

        public static boolean isAnagram(String word, String anagram) {
            if (word.length() != anagram.length()) {
                return false;
            }
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = anagram.indexOf(c);
                if (index != -1) {
                    anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
                } else {
                    return false;
                }
            }
            return anagram.isEmpty();
        }
    }

