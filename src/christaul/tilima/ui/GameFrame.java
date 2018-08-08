package christaul.tilima.ui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import christaul.tilima.Game;

public class GameFrame
	extends JFrame
{
	private static final long serialVersionUID = 4289431208659879050L;

	private static final int GAME_WIDTH = 320;
	private static final int GAME_HEIGHT = 320;

	private Canvas canvas;

	private Game game;

	public GameFrame()
	{
		super("Tilima");

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		canvas.setMaximumSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		canvas.setMinimumSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		canvas.setFocusable(false);

		KeyBoardPlayerInput arrowsInput = new KeyBoardPlayerInput(
				KeyEvent.VK_UP,
				KeyEvent.VK_DOWN,
				KeyEvent.VK_LEFT,
				KeyEvent.VK_RIGHT);

		KeyBoardPlayerInput wasdInput = new KeyBoardPlayerInput(
				KeyEvent.VK_W,
				KeyEvent.VK_S,
				KeyEvent.VK_A,
				KeyEvent.VK_D);

		setSize(GAME_WIDTH, GAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(arrowsInput);
		addKeyListener(wasdInput);
		add(canvas);
		pack();

		game = new Game(GAME_WIDTH, GAME_HEIGHT, arrowsInput, wasdInput);
		game.start(canvas);
	}

	public static void main(String[] args)
	{
		new GameFrame();
	}
}
