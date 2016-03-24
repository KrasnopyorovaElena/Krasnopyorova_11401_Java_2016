import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;


public class testsWithSpringConfig {

        //Game Class Tests
        @Test
        public void gameConstructorShouldSetCorrectParam(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            Assert.assertTrue(game.getServerThreads()[0] == st1 && game.getServerThreads()[1] == st2);

        }

        @Test
        public void StartGameShouldSetCorrectParam(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Game game=(Game) context.getBean("game");
            game.startGame(1,"He LL o ");
            Assert.assertEquals(game.getWord(), "hello");

        }

        @Test
        public void StartGameShouldSetCorrectParam2(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Game game=(Game) context.getBean("game");
            game.startGame(1, "He LL o ");
            Assert.assertTrue(game.getState() == 2);

        }

        @Test
        public void SayWordShouldSetCorrectWord(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Game game=(Game) context.getBean("game");
            game.startGame(1, "Sp RING");
            game.sayWord(1, "sp ri NG");
            Assert.assertEquals(game.getSaidWords().get(0), "spring");

        }

        @Test
        public void SayWordShouldNotAddTheSameWordToList(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Game game=(Game) context.getBean("game");
            game.startGame(0, "Spring");
            game.sayWord(0, "gnirps");
            game.sayWord(1, "gnirps");
            Assert.assertEquals(game.getSaidWords().size(), 1);

        }

        @Test
        public void SayWordShouldNotAddTheWrongAnnagram(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Game game=(Game) context.getBean("game");
            game.startGame(0, "Spring");
            game.sayWord(0, "ring");
            Assert.assertEquals(game.getSaidWords().size(), 0);

        }

        @Test public void isAnnagramShouldGetTrueToCorrectParam(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Game game=(Game) context.getBean("game");
            Assert.assertTrue(game.isAnagram("spring", "gnirps"));
        }

        @Test
        public void isAnnagramShouldGetFalseToWrongParam(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Game game=(Game) context.getBean("game");
            Assert.assertFalse(game.isAnagram("spring", "ssprin"));
        }

        @Test
        public void isAnnagramShouldGetFalseToWrongAnnagram(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Game game=(Game) context.getBean("game");
            Assert.assertFalse(game.isAnagram("spring", "ring"));
        }

        @Test
        public void loseShouldGetCorrectState(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Game game=(Game) context.getBean("game");
            game.lose(1);
            Assert.assertTrue(game.getState() == 5);
        }



        @Test
        public void getTurnShouldChangeStateOfGameCorrectly() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "Hello!I want to play with you!"); //������� ��������� �� 1���
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            Assert.assertEquals(game.getState(), 2);
        }


        @Test
        public void getTurnShouldChangeStateOfGameCorrectly2() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1, "Hello!");
            game.getTurn(1, "/w spirng");//��������� 2���,������� ���� � 1

            Assert.assertEquals(game.getState(), 1);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly3() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1, "/w spirng");//��������� 2���
            game.getTurn(0,"I don't like your word"); //������� ��������� �� 1���
            game.getTurn(0,"/a"); //1 ��� �� �������� �������� �������
            Assert.assertEquals(game.getState(), 4);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly4() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1, "/w spirng");//��������� 2���
            game.getTurn(0,"/a"); //1 ��� �� �������� �������� �������
            game.getTurn(1,"/d");//2�� ���������, ��� � 1

            Assert.assertEquals(game.getState(), 1);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly5() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1,"/a"); //������� �� �������� �������� 1���

            Assert.assertEquals(game.getState(), 3);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly6() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1,"/a");
            game.getTurn(0,"/d");//1�� ���������, ��� �������

            Assert.assertEquals(game.getState(), 2);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly7() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1, "/w spirng");//��������� 2���
            game.getTurn(0,"/a");
            game.getTurn(1,"/w sprign");
            game.getTurn(0,"/w psring");
            game.getTurn(1,"/a");
            game.getTurn(0,"/w ringsp");
            game.getTurn(1,"/end");

            Assert.assertEquals(game.getState(), 5);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly8() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1,"/end");//����������� ��������� ����
            game.getTurn(0,"/no");//������ ���������

            Assert.assertEquals(game.getState(), 1);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly9() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1, "/w spirng");//��������� 2���
            game.getTurn(0,"/end"); //����������� ��������� ����

            Assert.assertEquals(game.getState(), 6);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly10() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1, "/w spirng");//��������� 2���
            game.getTurn(0,"/end");
            game.getTurn(1,"/no");

            Assert.assertEquals(game.getState(), 2);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly11() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1,"/end");
            game.getTurn(0,"/yes");

            Assert.assertEquals(game.getState(), 7);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly12() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1, "/w spirng");//��������� 2���
            game.getTurn(0,"/end");
            game.getTurn(1,"/yes");

            Assert.assertEquals(game.getState(), 7);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly13() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);

            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1, "/surr");//��������� 2���

            Assert.assertEquals(game.getState(), 7);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly14() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);

            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1, "/w spirng");//��������� 2���
            game.getTurn(0,"/surr");

            Assert.assertEquals(game.getState(), 7);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly15() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);

            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1,"/surr");
            game.getTurn(1,"/start spring");

            Assert.assertEquals(game.getState(), 2);
        }

        @Test
        public void getTurnShouldChangeStateOfGameCorrectly16() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);

            game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
            game.getTurn(0, "/w gnirps"); //��������� �� 1���
            game.getTurn(1,"/surr");
            game.getTurn(1,"bye");

            Assert.assertEquals(game.getState(), 7);
        }

        @Test
        public void ServerThreadShouldBeAbleToRun() throws IOException {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            ServerThread st1 = (ServerThread) context.getBean("st1");
            ServerThread st2 = (ServerThread) context.getBean("st2");
            Game game=(Game) context.getBean("game");
            st1.setGame(game);
            st2.setGame(game);
            st1.run();
            st2.run();

        }


    }


