import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class tests {

    //Game Class Tests
    @Test
    public void gameConstructorShouldSetCorrectParam(){

        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        Assert.assertTrue(game.getServerThreads()[0] == st1 && game.getServerThreads()[1] == st2);

    }

    @Test
    public void StartGameShouldSetCorrectParam(){
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        game.startGame(1,"He LL o ");
        Assert.assertEquals(game.getWord(), "hello");

    }

    @Test
    public void StartGameShouldSetCorrectParam2(){
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        game.startGame(1, "He LL o ");
        Assert.assertTrue(game.getState() == 2);

    }

    @Test
    public void SayWordShouldSetCorrectWord(){
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        game.startGame(1, "Sp RING");
        game.sayWord(1, "sp ri NG");
        Assert.assertEquals(game.getSaidWords().get(0), "spring");

    }

    @Test
    public void SayWordShouldNotAddTheSameWordToList(){
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        game.startGame(0, "Spring");
        game.sayWord(0, "gnirps");
        game.sayWord(1, "gnirps");
        Assert.assertEquals(game.getSaidWords().size(), 1);

    }

    @Test
    public void SayWordShouldNotAddTheWrongAnnagram(){
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        game.startGame(0, "Spring");
        game.sayWord(0, "ring");
        Assert.assertEquals(game.getSaidWords().size(), 0);

    }

    @Test public void isAnnagramShouldGetTrueToCorrectParam(){
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        Assert.assertTrue(game.isAnagram("spring", "gnirps"));
    }

    @Test
    public void isAnnagramShouldGetFalseToWrongParam(){
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        Assert.assertFalse(game.isAnagram("spring", "ssprin"));
    }

    @Test
    public void isAnnagramShouldGetFalseToWrongAnnagram(){
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        Assert.assertFalse(game.isAnagram("spring", "ring"));
    }

    @Test
    public void loseShouldGetCorrectState(){
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game=new Game(st1,st2);
        game.lose(1);
        Assert.assertTrue(game.getState() == 5);
    }



    @Test
    public void getTurnShouldChangeStateOfGameCorrectly() {
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
        st1.setGame(game);
        st2.setGame(game);
        game.getTurn(0, "Hello!I want to play with you!"); //������� ��������� �� 1���
        game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
        game.getTurn(0, "/w gnirps"); //��������� �� 1���
        Assert.assertEquals(game.getState(), 2);
    }


    @Test
    public void getTurnShouldChangeStateOfGameCorrectly2() {
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
        st1.setGame(game);
        st2.setGame(game);
        game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
        game.getTurn(0, "/w gnirps"); //��������� �� 1���
        game.getTurn(1,"/a"); //������� �� �������� �������� 1���

        Assert.assertEquals(game.getState(), 3);
    }

    @Test
    public void getTurnShouldChangeStateOfGameCorrectly6() {
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
        st1.setGame(game);
        st2.setGame(game);

        game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
        game.getTurn(0, "/w gnirps"); //��������� �� 1���
        game.getTurn(1, "/surr");//��������� 2���

        Assert.assertEquals(game.getState(), 7);
    }

    @Test
    public void getTurnShouldChangeStateOfGameCorrectly14() {
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
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
        ServerThread st1 = mock(ServerThread.class);
        ServerThread st2 = mock(ServerThread.class);
        Game game = new Game(st1, st2);
        st1.setGame(game);
        st2.setGame(game);

        game.getTurn(0, "/start spring"); //1�� ����� ���� �� ������ Spring
        game.getTurn(0, "/w gnirps"); //��������� �� 1���
        game.getTurn(1,"/surr");
        game.getTurn(1,"bye");

        Assert.assertEquals(game.getState(), 7);
    }

    @Test
    public void ServerThreadShouldBeAbleToRun() throws IOException{
        Socket s1 = mock(Socket.class);
        Socket s2 = mock(Socket.class);
        byte [] bytes = new byte[]{5,6};
        ByteArrayInputStream is2= new ByteArrayInputStream(bytes);
        OutputStream os = mock(OutputStream.class);

        when(s1.getInputStream()).thenReturn(is2);
        when(s2.getInputStream()).thenReturn(is2);
        when(s1.getOutputStream()).thenReturn(os);
        when(s2.getOutputStream()).thenReturn(os);

        ServerThread st1 = new ServerThread(s1,0);
        ServerThread st2 = new ServerThread(s2,1);
        Game g = new Game(st1,st2);
        st1.setGame(g);
        st2.setGame(g);
        st1.run();
        st2.run();

    }


}
