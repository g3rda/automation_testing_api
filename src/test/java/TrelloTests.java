import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

public class TrelloTests {
    private String boardId;
    private String listId;
    private String cardId;

    @Test (priority = 1)
    public void checkCreateBoard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

        Board board = new Board();
        String name = "board_name";

        Board createdBoard = retrofitBuilder.getTrelloApi().createBoard(board, name).execute().body();
        boardId = createdBoard.getId();
        Assert.assertEquals(createdBoard.getName(), name);

    }

//    @Test
//    public void checkUpdateBoard() throws IOException {
//        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
//        Board board = new Board();
//        String updatedName = "Music4";
//        board.setName(updatedName);
//
//        Board updatedBoard = retrofitBuilder.getTrelloApi().updateBoard(board, boardId).execute().body();
//        Assert.assertEquals(updatedBoard.getName(), updatedName);
//
//    }

    @Test (priority = 7)
    public void checkDeleteBoard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        int code = retrofitBuilder.getTrelloApi().deleteBoard(boardId, board.getKey(), board.getToken()).execute().code();

        Assert.assertEquals(code, 200);


    }

    @Test (priority = 2)
    public void checkCreateList() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        String name = "list_name";
        List createdList = retrofitBuilder.getTrelloApi().createList(name, boardId,  board.getKey(), board.getToken()).execute().body();
        listId = createdList.getId();
        Assert.assertEquals(createdList.getName(), name);
    }

    @Test (priority = 3)
    public void checkCreateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        Card card = new Card("card_name",  "some_info", listId);
        Card createdCard = retrofitBuilder.getTrelloApi().createCard(card, board.getKey(), board.getToken()).execute().body();
        cardId = createdCard.getId();
        Assert.assertEquals(createdCard.getName(), card.getName());
    }

    @Test (priority = 4)
    public void checkUpdateCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        Card card = new Card("new_card_name", "some_new_info", cardId, listId);
        Date date = new Date(	System.currentTimeMillis()+1000*60*60*24*5);
        card.setDue(date);
        Card createdCard = retrofitBuilder.getTrelloApi().updateCard(card, cardId, board.getKey(), board.getToken()).execute().body();
        Assert.assertEquals(createdCard.getName(), card.getName());
    }

    @Test (priority = 6)
    public void checkDeleteCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        int code = retrofitBuilder.getTrelloApi().deleteCard(cardId, board.getKey(), board.getToken()).execute().code();
        Assert.assertEquals(code, 200);
    }

    @Test (priority = 5)
    public void checkGetCard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        Card card = retrofitBuilder.getTrelloApi().getCard(cardId, board.getKey(), board.getToken()).execute().body();
        card.getInfo();
        Assert.assertEquals(card.getId(), cardId);
    }


}
