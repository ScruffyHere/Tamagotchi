import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class myTamagotchi extends JFrame {
	

	private final static int WIDTH = 1000;
	private final static int HEIGHT = 500;

	protected BufferedImage petUp;
	protected BufferedImage feedIcon;
	
	private JLabel petAge, petAgenum;
	private JLabel petHappiness, petHappinessnum;
	private JLabel petEnergy, petEnergynum;
	private JLabel petHunger, petHungernum;
	public JLabel petConsolemessage;
	private JPanel petState, petControls, petVisuals, petConsole, statusPanel, petControlButtons;
	private JButton petFeed, petSleep, petPlay;
	
	public JLabel petPictures;
	public ImageIcon[] yodaPics;

	public int happiness = 100;
	public int happinessMax = 0;
	public int happinessIncrease = 2;
	public int happinessDecrease = -4;

	public int hunger = 10;
	public int hungerMax = 100;
	public int hungerIncrease = 2;
	public int hungerDecrease = 4;

	public int energy = 15;
	public int energyMax = 100;
	public int energyIncrease = 2;
	public int energyDecrease = 4;

	public int age = 0;

	public boolean alive = true;

	
	public void paint(Graphics g) {
		super.paint(g);

		g.drawLine(500, 0, 500, 500);
		g.drawLine(-500, 250, 1000, 250);
	}
	
	
	public void setPetIconState(int state) {
		petPictures.setIcon(yodaPics[state]);
	}

	
	public void myGUI(String[] petIcons, String[] interactIcons, String[] toolTips) {

		
		/**
		 * GUI settings
		 */

		setResizable(false);
		setSize(this.WIDTH, this.HEIGHT);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		validate();

		
		/**
		 * GUI
		 */

		GridBagConstraints c = new GridBagConstraints();

		
		/**
		 * petState panel
		 */

		petState = new JPanel();
		petState.setPreferredSize(new Dimension(450, 200));
		petState.setLayout(new GridLayout(4, 2));

		petAge = new JLabel("Age: ");
		petHappiness = new JLabel("Happiness: ");
		petHunger = new JLabel("Hunger: ");
		petEnergy = new JLabel("Energy: ");
		
		petAgenum = new JLabel();
		petHungernum = new JLabel();
		petEnergynum = new JLabel();
		petHappinessnum = new JLabel();

		petState.add(petAge);
		petState.add(petAgenum);
		
		petState.add(petHappiness);
		petState.add(petHappinessnum);
		
		petState.add(petHunger);
		petState.add(petHungernum);
		
		petState.add(petEnergy);
		petState.add(petEnergynum);
		
		
		/**
		 * statusPanel	-	used for testing the code mechanics manually and also
		 * used as an empty space to push down pet control buttons to the bottom
		 */

		statusPanel = new JPanel();
		statusPanel.setPreferredSize(new Dimension(450, 200));
		statusPanel.setLayout(new FlowLayout());
		//statusPanel.add("Put console button here for testing outputs manually");

		
		/**
		 * petControls
		 */

		petControls = new JPanel();
		petControls.setPreferredSize(new Dimension(450, 200));
		petControls.setLayout(new GridLayout(2, 3));

		petControlButtons = new JPanel();
		petControlButtons.setPreferredSize(new Dimension(450, 200));
		petControlButtons.setLayout(new FlowLayout());
		
		ImageIcon feed = new ImageIcon(interactIcons[0]);
		Image feedImg = feed.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon feeding = new ImageIcon(feedImg);
		
		petFeed = new JButton();
		petFeed.setIcon(feeding);
		petFeed.setToolTipText(toolTips[0]);
		petFeed.setPreferredSize(new Dimension(90, 90));

		ImageIcon sleep = new ImageIcon(interactIcons[1]);
		Image sleepImg = sleep.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon sleeping = new ImageIcon(sleepImg);
		
		petSleep = new JButton();
		petSleep.setIcon(sleeping);
		petSleep.setToolTipText(toolTips[1]);
		petSleep.setPreferredSize(new Dimension(90, 90));
		
		ImageIcon play = new ImageIcon(interactIcons[2]);
		Image playImg = play.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		ImageIcon playing = new ImageIcon(playImg);

		petPlay = new JButton();
		petPlay.setIcon(playing);
		petPlay.setToolTipText(toolTips[2]);
		petPlay.setPreferredSize(new Dimension(90, 90));

		petControlButtons.add(petFeed);
		petControlButtons.add(petSleep);
		petControlButtons.add(petPlay);

		petControls.add(statusPanel);
		petControls.add(petControlButtons);

		
		/**
		 * petVisuals
		 */

		petVisuals = new JPanel();
		petVisuals.setPreferredSize(new Dimension(450, 200));
		
		
		ImageIcon yodaDead = new ImageIcon(petIcons[0]);
		Image yodaDeadImg = yodaDead.getImage().getScaledInstance(190, 190, Image.SCALE_SMOOTH);
		ImageIcon yodaDeading = new ImageIcon(yodaDeadImg);
		
		ImageIcon yodaDown = new ImageIcon(petIcons[1]);
		Image yodaDownImg = yodaDown.getImage().getScaledInstance(190, 190, Image.SCALE_SMOOTH);
		ImageIcon yodaDowning = new ImageIcon(yodaDownImg);
		
		ImageIcon yodaSleep = new ImageIcon(petIcons[2]);
		Image yodaSleepImg = yodaSleep.getImage().getScaledInstance(190, 190, Image.SCALE_SMOOTH);
		ImageIcon yodaSleeping = new ImageIcon(yodaSleepImg);
		
		ImageIcon yodaUp = new ImageIcon(petIcons[3]);
		Image yodaUpImg = yodaUp.getImage().getScaledInstance(190, 190, Image.SCALE_SMOOTH);
		ImageIcon yodaUping = new ImageIcon(yodaUpImg);
		
		yodaPics = new ImageIcon[4];
		yodaPics[0] = yodaUping;
		yodaPics[1] = yodaDowning;
		yodaPics[2] = yodaSleeping;
		yodaPics[3] = yodaDeading;

		petPictures = new JLabel();
		setPetIconState(0);
		
		petVisuals.add(petPictures);
		

		/**
		 * petConsole
		 */

		petConsole = new JPanel();
		petConsole.setPreferredSize(new Dimension(450, 200));
		
		String startUp = "";
		startUp += "<html>This is your personal YodaGotchi <br/>";
		startUp += "Take good care of it by interacting with the master. <br/>";
		startUp += "Do or do not. There is no try. </html>";

		petConsolemessage = new JLabel(startUp);

		petConsole.add(Box.createVerticalStrut(150));
		petConsole.add(petConsolemessage);

		
		/**
		 * JFrame
		 */

		c.gridx = 0;
		c.gridy = 1;
		add(petState, c);

		c.gridx = 1;
		c.gridy = 1;
		add(petControls, c);

		c.gridx = 0;
		c.gridy = 0;
		add(petVisuals, c);

		c.gridx = 1;
		c.gridy = 0;
		add(petConsole, c);
		
		revalidate();
		repaint();
	}

	public myTamagotchi(String title, String[] petIcons, String[] toolTips, String[] interactIcons) {
		super(title);
		myGUI(petIcons, interactIcons, toolTips);

		petFeed.addMouseListener(new eventHandler());
		petSleep.addMouseListener(new eventHandler());
		petPlay.addMouseListener(new eventHandler());
		
		long systemTime = 0;
		
		while(alive) {
			if (System.currentTimeMillis() - systemTime >= 1500) {
				cycle();

				if(energy <= 0) {
					alive = false;
					setPetIconState(3);
					petConsolemessage.setText("<html>Death is a natural part of life. <br>Rejoice for those around you who transform into the Force. <br>Mourn them do not. <br><br>You killed Master Yoda</html>");
					revalidate();
					repaint();
					break;
				}
				
				if(energy <= 10) {
					setPetIconState(1);
					petConsolemessage.setText("<html>Patience you must have, my young padawan. <br><br> Yoda is feeling a bit drowsy</html>");
					revalidate();
					repaint();
				}
				
				if (energy > 15) {
					setPetIconState(0);
					petConsolemessage.setText("<html>May the force be with you padawan</html>");
					revalidate();
					repaint();
				}
				
				if (energy > 20) {
					setPetIconState(0);
					petConsolemessage.setText("<html>May the force be with you padawan. <br><br> Master Yoda is idle <br><br> Maybe you should play with your Master padawan</html>");
					revalidate();
					repaint();
				}
				
				if(happiness < 0) {
					setPetIconState(1);
					revalidate();
					repaint();
				}
				
				if(hunger >= 50)	{
					setPetIconState(1);
					petConsolemessage.setText("<html>The greatest teacher, failure is.. <br><br> Yoda is feeling a nauseous</html>");
					revalidate();
					repaint();
				}
				systemTime = System.currentTimeMillis();
			}
		}
	}


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String[] petIcons = { "src/images/YodaGotchiDead.png", "src/images/YodaGotchiDown.png", "src/images/YodaGotchiSleep.png",
				"src/images/YodaGotchiUp.png" };

		String[] toolTips = { "Feed Yoda", "Yoda Sleeps", "Play with Yoda" };

		String[] interactIcons = { "src/images/feed.png", "src/images/sleep.png", "src/images/play.png" };

		myTamagotchi myPet = new myTamagotchi("Judge me by my size, do you?", petIcons, toolTips, interactIcons);
	}

	
	private class eventHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == petPlay) {
				play();
			}

			if (e.getSource() == petSleep) {
				sleep();
			}

			if (e.getSource() == petFeed) {
				eat();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}

	
	public void play() {
		String result = "";
		if (hunger > 50) {
			result = "Yoda is too hunger to play.";
		} else if (energy > 20) {
			happiness += 32;
			energy -= 15;
			hunger += 15;
			result += "<html>Control, control, you must learn control! <br><br> Masters feelings has been noticed</html>";
			petConsolemessage.setText(result);
		}	else	{
			result += "Yoda is too tired to play.";
		}
		petConsolemessage.setText(result);
	}
	
	
	public void eat() {
		String result = "";

		if (hunger >= 50) {
			hunger = 0;
			energy-= 15;
			result += "Yoda has been fed";
			petConsolemessage.setText(result);
		}	else	{
			result += "Yoda is not hungry enough to eat";
			petConsolemessage.setText(result);
		}
	}
	
	
	public void cycle() {
		randomEvent();
		hunger += hungerIncrease;
		happiness += happinessDecrease;
		energy += energyDecrease;
		age += 2;

		if(happiness <= 0)	{
			hungerIncrease = 5;
		}	else	{
			hungerIncrease = 2;
		}
		
		
		if(hunger == 100) {
			energyDecrease = -5;
		}	else	{
			energyDecrease = -2;
		}
		
		
		petAgenum.setText(Integer.toString(age));
		petHappinessnum.setText(Integer.toString(happiness));
		petHungernum.setText(Integer.toString(hunger));
		petEnergynum.setText(Integer.toString(energy));
	}

	
	public void sleep() {
		if(energy <= 10)	{
			energy += 25;
			hunger += hungerIncrease;
			happiness += happinessIncrease;
			petEnergynum.setText(Integer.toString(energy));
			setPetIconState(2);
			revalidate();
			repaint();
		}
	}

	
	public void randomEvent() {
		switch ((int) (Math.random() * 32)) {

		case 12:
			hunger++;
			break;

		case 16:
			energy--;
			break;

		case 18:
			energy++;
			break;

		case 7:
			happiness++;
			break;

		case 4:
			happiness--;
			break;

		default:
			break;
		}
	}
}