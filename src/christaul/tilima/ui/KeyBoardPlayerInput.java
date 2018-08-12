package christaul.tilima.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import christaul.tilima.inputs.PlayerInput;

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

	private int mouseX = -1;
	private int mouseY = -1;

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
		try
		{
			return mouseX;
		}
		finally
		{
			mouseX = -1;
		}
	}

	@Override
	public int getMouseY()
	{
		try
		{
			return mouseY;
		}
		finally
		{
			mouseY = -1;
		}
	}
}
