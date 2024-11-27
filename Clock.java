import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
public class Clock extends JPanel implements ActionListener {
	public static void main(String[] args) {

		new Clock();
		
	}
	JLabel backgroundForBL = new JLabel();
	JLabel calendarBackground = new JLabel();
	BufferedImage logoImg;
	JLabel picLabel;
	boolean secondsCountVisible = true;
	JLabel placeholder = new JLabel(":)");
	JTextArea notes = new JTextArea("Enter notes here...");
	JLabel activateDesc = new JLabel("Turn seconds on/off: ");
	JLabel time = new JLabel("00:00:00");
	JLabel date = new JLabel("01/01/2000");
	JButton secondsVisButton = new JButton("Hide");
	JPanel clockPanel = new JPanel();
	LocalTime timetime = LocalTime.now();
	LocalDate datedate = LocalDate.now();
	int dayday = datedate.getDayOfMonth();
	Font daysFont = new Font("Arial", Font.PLAIN, 14);
	JFrame clockFrame = new JFrame();
	Border timeborder = BorderFactory.createEmptyBorder();
	Border notesBorder = BorderFactory.createLineBorder(Color.black,1);
	Border daysBorder = BorderFactory.createLineBorder(new Color(200, 210, 220).darker(),1);
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
	static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	// set day
	JLabel day1 = new JLabel("1");
	JLabel day2 = new JLabel("2");
	JLabel day3 = new JLabel("3");
	JLabel day4 = new JLabel("4");
	JLabel day5 = new JLabel("5");
	JLabel day6 = new JLabel("6");
	JLabel day7 = new JLabel("7");
	JLabel day8 = new JLabel("8");
	JLabel day9 = new JLabel("9");
	JLabel day10 = new JLabel("10");
	JLabel day11 = new JLabel("11");
	JLabel day12 = new JLabel("12");
	JLabel day13 = new JLabel("13");
	JLabel day14 = new JLabel("14");
	JLabel day15 = new JLabel("15");
	JLabel day16 = new JLabel("16");
	JLabel day17 = new JLabel("17");
	JLabel day18 = new JLabel("18");
	JLabel day19 = new JLabel("19");
	JLabel day20 = new JLabel("20");
	JLabel day21 = new JLabel("21");
	JLabel day22 = new JLabel("22");
	JLabel day23 = new JLabel("23");
	JLabel day24 = new JLabel("24");
	JLabel day25 = new JLabel("25");
	JLabel day26 = new JLabel("26");
	JLabel day27 = new JLabel("27");
	JLabel day28 = new JLabel("28");
	JLabel day29 = new JLabel("29");
	JLabel day30 = new JLabel("30");
	JLabel day31 = new JLabel("31");
	// ---
	JLabel credit = new JLabel("GitHub: @jaxolydian");

Clock() {
	// set days
	setDays();


// other
	clockPanel.setBounds(0, 0, 500, 575);
	clockFrame.setResizable(false);
	clockPanel.setLayout(null);
	backgroundForBL.setBounds(12, 298, 462, 95);
	backgroundForBL.setBorder(notesBorder);
	backgroundForBL.setOpaque(true);
	backgroundForBL.setBackground(Color.white);
	calendarBackground.setBounds(225, 85, 250, 200);
	calendarBackground.setBorder(BorderFactory.createTitledBorder(notesBorder, "Monthly Calendar - "+datedate.getMonth()+" "+dayday+", "+datedate.getYear(), TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Roboto", Font.BOLD, 12)));
	calendarBackground.setOpaque(true);
	calendarBackground.setBackground(Color.white);
	time.setFont(new Font("Segoe UI Symbol", Font.BOLD, 45));
	time.setBorder(timeborder);
	time.setFocusable(false);
	time.setOpaque(false);
	time.setHorizontalTextPosition(SwingConstants.CENTER);
	time.setLocation(20, 330);
	time.setSize(265, 60);
	date.setFont(new Font("Segoe UI Symbol", Font.BOLD, 45));
	date.setBorder(notesBorder);
	date.setFocusable(false);
	date.setLocation(225, 15);
	date.setSize(250, 55);
	date.setBackground(Color.white);
	date.setOpaque(true);
	secondsVisButton.setLocation(170, 307);
	secondsVisButton.setBackground(new Color(234, 234, 234));
	secondsVisButton.setSize(65, 30);
	secondsVisButton.setFont(new Font("Roboto", Font.ITALIC, 13));
	secondsVisButton.addActionListener(this);
	

	credit.setBounds(365, 397, 125, 16);
	credit.setOpaque(false);
	credit.setVisible(true);
	activateDesc.setBounds(22, 307, 160, 30);
	activateDesc.setVisible(true);
	activateDesc.setOpaque(false);
	activateDesc.setFont(new Font("Roboto", Font.PLAIN, 16));
	notes.setBounds(10, 15, 205, 270);
	notes.setVisible(true);
	notes.setLineWrap(true);
	notes.setBorder(BorderFactory.createTitledBorder(notesBorder, "Daily Notes", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Roboto", Font.BOLD, 12)));
	notes.setMargin(new Insets(10,10,10,10));
	notes.setFont(new Font("Roboto", Font.PLAIN, 12));
	try {
		logoImg = ImageIO.read(getClass().getResource("/imgs/logo.png"));

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	clockFrame.setIconImage(logoImg);
	picLabel = new JLabel(new ImageIcon(logoImg));
	clockFrame.setTitle("Clock Program");
	clockFrame.setSize(500, 455);
	clockFrame.setVisible(true);
	clockFrame.add(time);
	clockFrame.add(credit);
	//set day
	addingDays(clockFrame);
	// ---
	
	clockFrame.add(notes);
	clockFrame.add(activateDesc);
	clockFrame.add(date);
	clockFrame.add(secondsVisButton);
	clockFrame.add(backgroundForBL);
	clockFrame.add(calendarBackground);
	clockFrame.add(clockPanel);
	
	startWaiting(datedate, timetime, time, date, clockFrame);
	
	clockFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	

}
	private void addingDays(JFrame clockFrame)
	{
		clockFrame.add(day1);
		clockFrame.add(day2);
		clockFrame.add(day3);
		clockFrame.add(day4);
		clockFrame.add(day5);
		clockFrame.add(day6);
		clockFrame.add(day7);
		clockFrame.add(day8);
		clockFrame.add(day9);
		clockFrame.add(day10);
		clockFrame.add(day11);
		clockFrame.add(day12);
		clockFrame.add(day13);
		clockFrame.add(day14);
		clockFrame.add(day15);
		clockFrame.add(day16);
		clockFrame.add(day17);
		clockFrame.add(day18);
		clockFrame.add(day19);
		clockFrame.add(day20);
		clockFrame.add(day21);
		clockFrame.add(day22);
		clockFrame.add(day23);
		clockFrame.add(day24);
		clockFrame.add(day25);
		clockFrame.add(day26);
		clockFrame.add(day27);
		clockFrame.add(day28);
		clockFrame.add(day29);
		clockFrame.add(day30);
		clockFrame.add(day31);
		
	}

	private void setDays()
	{
		day1.setBounds(235, 105, 25, 25);
		day2.setBounds(269, 105, 25, 25);
		day3.setBounds(303, 105, 25, 25);
		day4.setBounds(338, 105, 25, 25);
		day5.setBounds(372, 105, 25, 25);
		day6.setBounds(406, 105, 25, 25);
		day7.setBounds(440, 105, 25, 25);
		day8.setBounds(235, 140, 25, 25);
		day9.setBounds(269, 140, 25, 25);
		day10.setBounds(303, 140, 25, 25);
		day11.setBounds(338, 140, 25, 25);
		day12.setBounds(372, 140, 25, 25);
		day13.setBounds(406, 140, 25, 25);
		day14.setBounds(440, 140, 25, 25);
		day15.setBounds(235, 175, 25, 25);
		day16.setBounds(269, 175, 25, 25);
		day17.setBounds(303, 175, 25, 25);
		day18.setBounds(338, 175, 25, 25);
		day19.setBounds(372, 175, 25, 25);
		day20.setBounds(406, 175, 25, 25);
		day21.setBounds(440, 175, 25, 25);
		day22.setBounds(235, 210, 25, 25);
		day23.setBounds(269, 210, 25, 25);
		day24.setBounds(303, 210, 25, 25);
		day25.setBounds(338, 210, 25, 25);
		day26.setBounds(372, 210, 25, 25);
		day27.setBounds(406, 210, 25, 25);
		day28.setBounds(440, 210, 25, 25);
		day29.setBounds(235, 245, 25, 25);
		day30.setBounds(269, 245, 25, 25);
		day31.setBounds(303, 245, 25, 25);
		
		day1.setFont(daysFont);
		day2.setFont(daysFont);
		day3.setFont(daysFont);
		day4.setFont(daysFont);
		day5.setFont(daysFont);
		day6.setFont(daysFont);
		day7.setFont(daysFont);
		day8.setFont(daysFont);
		day9.setFont(daysFont);
		day10.setFont(daysFont);
		day11.setFont(daysFont);
		day12.setFont(daysFont);
		day13.setFont(daysFont);
		day14.setFont(daysFont);
		day15.setFont(daysFont);
		day16.setFont(daysFont);
		day17.setFont(daysFont);
		day18.setFont(daysFont);
		day19.setFont(daysFont);
		day20.setFont(daysFont);
		day21.setFont(daysFont);
		day22.setFont(daysFont);
		day23.setFont(daysFont);
		day24.setFont(daysFont);
		day25.setFont(daysFont);
		day26.setFont(daysFont);
		day27.setFont(daysFont);
		day28.setFont(daysFont);
		day29.setFont(daysFont);
		day30.setFont(daysFont);
		day31.setFont(daysFont);
		
		day1.setBorder(daysBorder);
		day2.setBorder(daysBorder);
		day3.setBorder(daysBorder);
		day4.setBorder(daysBorder);
		day5.setBorder(daysBorder);
		day6.setBorder(daysBorder);
		day7.setBorder(daysBorder);
		day8.setBorder(daysBorder);
		day9.setBorder(daysBorder);
		day10.setBorder(daysBorder);
		day11.setBorder(daysBorder);
		day12.setBorder(daysBorder);
		day13.setBorder(daysBorder);
		day14.setBorder(daysBorder);
		day15.setBorder(daysBorder);
		day16.setBorder(daysBorder);
		day17.setBorder(daysBorder);
		day18.setBorder(daysBorder);
		day19.setBorder(daysBorder);
		day20.setBorder(daysBorder);
		day21.setBorder(daysBorder);
		day22.setBorder(daysBorder);
		day23.setBorder(daysBorder);
		day24.setBorder(daysBorder);
		day25.setBorder(daysBorder);
		day26.setBorder(daysBorder);
		day27.setBorder(daysBorder);
		day28.setBorder(daysBorder);
		day29.setBorder(daysBorder);
		day30.setBorder(daysBorder);
		day31.setBorder(daysBorder);
		
		day1.setOpaque(true);
		day2.setOpaque(true);
		day3.setOpaque(true);
		day4.setOpaque(true);
		day5.setOpaque(true);
		day6.setOpaque(true);
		day7.setOpaque(true);
		day8.setOpaque(true);
		day9.setOpaque(true);
		day10.setOpaque(true);
		day11.setOpaque(true);
		day12.setOpaque(true);
		day13.setOpaque(true);
		day14.setOpaque(true);
		day15.setOpaque(true);
		day16.setOpaque(true);
		day17.setOpaque(true);
		day18.setOpaque(true);
		day19.setOpaque(true);
		day20.setOpaque(true);
		day21.setOpaque(true);
		day22.setOpaque(true);
		day23.setOpaque(true);
		day24.setOpaque(true);
		day25.setOpaque(true);
		day26.setOpaque(true);
		day27.setOpaque(true);
		day28.setOpaque(true);
		day29.setOpaque(true);
		day30.setOpaque(true);
		day31.setOpaque(true);
		
		day1.setBackground(new Color(234, 234, 234));
		day2.setBackground(new Color(234, 234, 234));
		day3.setBackground(new Color(234, 234, 234));
		day4.setBackground(new Color(234, 234, 234));
		day5.setBackground(new Color(234, 234, 234));
		day6.setBackground(new Color(234, 234, 234));
		day7.setBackground(new Color(234, 234, 234));
		day8.setBackground(new Color(234, 234, 234));
		day9.setBackground(new Color(234, 234, 234));
		day10.setBackground(new Color(234, 234, 234));
		day11.setBackground(new Color(234, 234, 234));
		day12.setBackground(new Color(234, 234, 234));
		day13.setBackground(new Color(234, 234, 234));
		day14.setBackground(new Color(234, 234, 234));
		day15.setBackground(new Color(234, 234, 234));
		day16.setBackground(new Color(234, 234, 234));
		day17.setBackground(new Color(234, 234, 234));
		day18.setBackground(new Color(234, 234, 234));
		day19.setBackground(new Color(234, 234, 234));
		day20.setBackground(new Color(234, 234, 234));
		day21.setBackground(new Color(234, 234, 234));
		day22.setBackground(new Color(234, 234, 234));
		day23.setBackground(new Color(234, 234, 234));
		day24.setBackground(new Color(234, 234, 234));
		day25.setBackground(new Color(234, 234, 234));
		day26.setBackground(new Color(234, 234, 234));
		day27.setBackground(new Color(234, 234, 234));
		day28.setBackground(new Color(234, 234, 234));
		day29.setBackground(new Color(234, 234, 234));
		day30.setBackground(new Color(234, 234, 234));
		day31.setBackground(new Color(234, 234, 234));
		
		
		
		switch (datedate.getDayOfMonth()) {
		case 1:
			day1.setBackground(new Color(200, 210, 220));
			break;
		case 2:
			day2.setBackground(new Color(200, 210, 220));
			break;
		case 3:
			day3.setBackground(new Color(200, 210, 220));
			break;
		case 4:
			day4.setBackground(new Color(200, 210, 220));
			break;
		case 5:
			day5.setBackground(new Color(200, 210, 220));
			break;
		case 6:
			day6.setBackground(new Color(200, 210, 220));
			break;
		case 7:
			day7.setBackground(new Color(200, 210, 220));
			break;
		case 8:
			day8.setBackground(new Color(200, 210, 220));
			break;
		case 9:
			day9.setBackground(new Color(200, 210, 220));
			break;
		case 10:
			day10.setBackground(new Color(200, 210, 220));
			break;
		case 11:
			day11.setBackground(new Color(200, 210, 220));
			break;
		case 12:
			day12.setBackground(new Color(200, 210, 220));
			break;
		case 13:
			day13.setBackground(new Color(200, 210, 220));
			break;
		case 14:
			day14.setBackground(new Color(200, 210, 220));
			break;
		case 15:
			day15.setBackground(new Color(200, 210, 220));
			break;
		case 16:
			day16.setBackground(new Color(200, 210, 220));
			break;
		case 17:
			day17.setBackground(new Color(200, 210, 220));
			break;
		case 18:
			day18.setBackground(new Color(200, 210, 220));
			break;
		case 19:
			day19.setBackground(new Color(200, 210, 220));
			break;
		case 20:
			day20.setBackground(new Color(200, 210, 220));
			break;
		case 21:
			day21.setBackground(new Color(200, 210, 220));
			break;
		case 22:
			day22.setBackground(new Color(200, 210, 220));
			break;
		case 23:
			day23.setBackground(new Color(200, 210, 220));
			break;
		case 24:
			day24.setBackground(new Color(200, 210, 220));
			break;
		case 25:
			day25.setBackground(new Color(200, 210, 220));
			break;
		case 26:
			day26.setBackground(new Color(200, 210, 220));
			break;
		case 27:
			day27.setBackground(new Color(200, 210, 220));
			break;
		case 28:
			day28.setBackground(new Color(200, 210, 220));
			break;
		case 29:
			day29.setBackground(new Color(200, 210, 220));
			break;
		case 30:
			day30.setBackground(new Color(200, 210, 220));
			break;
		case 31:
			day31.setBackground(new Color(200, 210, 220));
			break;
		}
		
	}
	public void actionPerformed(ActionEvent e) {  
        try { 
        	// seconds visible
        	if (e.getSource()==secondsVisButton) {
        		if (secondsCountVisible == true) {
        			secondsCountVisible = false;
        			secondsVisButton.setText("Show");
        		Clock.formatter = DateTimeFormatter.ofPattern("hh:mm a");
        		} else if (secondsCountVisible == false) {
        			secondsCountVisible = true;
        			secondsVisButton.setText("Hide");
        			Clock.formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        		}
        	}
        	
        	
        	// other
        } catch(Exception ex) {
        	System.out.println(ex);
        }  
    }
	// setup
	public static void startWaiting(LocalDate date, LocalTime time, JLabel t, JLabel d, JFrame cfexit) {
		int i = 0;
		while (i < 1) {
			cfexit.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		try {
			TimeUnit.NANOSECONDS.sleep(10000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		time = LocalTime.now();
		date = LocalDate.now();
		String datever = date.format(formatDate);
		String timever = time.format(formatter);
		d.setText(""+datever);
		t.setText(""+timever);
		}
	}
}
