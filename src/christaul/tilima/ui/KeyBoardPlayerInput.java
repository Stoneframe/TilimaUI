package christaul.tilima.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import christaul.tilima.inputs.PlayerInput;
import christaul.tilima.tiles.Tile;

public class KeyBoardPlayerInput
	extends PlayerInput
	implements
		KeyListener,
		MouseListener
{
	private boolean[] keys = new boolean[256];

	private int upKeyEvent;
	private int downKeyEvent;
	private int leftKeyEvent;
	private int rightKeyEvent;

	private int mouseX = 1 * Tile.WIDTH;
	private int mouseY = 2 * Tile.HEIGHT;

	public KeyBoardPlayerInput(
			int upKeyEvent,
			int downKeyEvent,
			int leftKeyEvent,
			int rightKeyEvent)
	{
		this.upKeyEvent = upKeyEvent;
		this.downKeyEvent = downKeyEvent;
		this.leftKeyEvent = leftKeyEvent;
		this.rightKeyEvent = rightKeyEvent;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void update()
	{
		if (keys[upKeyEvent])
		{
			movement = UP;
		}
		else if (keys[downKeyEvent])
		{
			movement = DOWN;
		}
		else if (keys[leftKeyEvent])
		{
			movement = LEFT;
		}
		else if (keys[rightKeyEvent])
		{
			movement = RIGHT;
		}
		else
		{
			movement = IDLE;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public int getMouseX()
	{
		return mouseX;
	}

	@Override
	public int getMouseY()
	{
		return mouseY;
	}
}
