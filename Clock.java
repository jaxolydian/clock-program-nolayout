import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
/** bad clock program
 * @author Jackson Philips
 * @date 11/2/2024
 * @description half-baked clock program
 */
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
	static JFrame clockFrame = new JFrame();
	Border timeborder = BorderFactory.createEmptyBorder();
	Border notesBorder = BorderFactory.createLineBorder(Color.black,1);
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
	static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	// set day
	JButton day1 = new JButton("1");
	JButton day2 = new JButton("2");
	JButton day3 = new JButton("3");
	JButton day4 = new JButton("4");
	JButton day5 = new JButton("5");
	JButton day6 = new JButton("6");
	JButton day7 = new JButton("7");
	JButton day8 = new JButton("8");
	JButton day9 = new JButton("9");
	JButton day10 = new JButton("10");
	JButton day11 = new JButton("11");
	JButton day12 = new JButton("12");
	JButton day13 = new JButton("13");
	JButton day14 = new JButton("14");
	JButton day15 = new JButton("15");
	JButton day16 = new JButton("16");
	JButton day17 = new JButton("17");
	JButton day18 = new JButton("18");
	JButton day19 = new JButton("19");
	JButton day20 = new JButton("20");
	JButton day21 = new JButton("21");
	JButton day22 = new JButton("22");
	JButton day23 = new JButton("23");
	JButton day24 = new JButton("24");
	JButton day25 = new JButton("25");
	JButton day26 = new JButton("26");
	JButton day27 = new JButton("27");
	JButton day28 = new JButton("28");
	JButton day29 = new JButton("29");
	JButton day30 = new JButton("30");
	JButton day31 = new JButton("31");
	// ---
Clock() {
	// set days
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
// other
	clockPanel.setBounds(0, 0, 500, 575);
	clockFrame.setResizable(false);
	clockPanel.setLayout(null);
	backgroundForBL.setBounds(10, 425, 460, 95);
	backgroundForBL.setBorder(notesBorder);
	backgroundForBL.setOpaque(true);
	backgroundForBL.setBackground(Color.white);
	calendarBackground.setBounds(225, 85, 250, 325);
	calendarBackground.setBorder(BorderFactory.createTitledBorder(notesBorder, "Monthly Calendar - "+datedate.getMonth()+" "+datedate.getYear(), TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Roboto", Font.BOLD, 12)));
	calendarBackground.setOpaque(true);
	calendarBackground.setBackground(Color.white);
	time.setFont(new Font("Segoe UI Symbol", Font.BOLD, 45));
	time.setBorder(timeborder);
	time.setFocusable(false);
	time.setOpaque(false);
	time.setHorizontalTextPosition(SwingConstants.CENTER);
	time.setLocation(17, 460);
	time.setSize(480, 60);
	date.setFont(new Font("Segoe UI Symbol", Font.BOLD, 45));
	date.setBorder(notesBorder);
	date.setFocusable(false);
	date.setLocation(225, 15);
	date.setSize(250, 55);
	date.setBackground(Color.white);
	date.setOpaque(true);
	secondsVisButton.setLocation(165, 435);
	secondsVisButton.setSize(65, 30);
	secondsVisButton.setFont(new Font("Roboto", Font.ITALIC, 13));
	secondsVisButton.addActionListener(this);
	placeholder.setVisible(false);
	activateDesc.setBounds(20, 435, 160, 30);
	activateDesc.setVisible(true);
	activateDesc.setOpaque(false);
	activateDesc.setFont(new Font("Roboto", Font.PLAIN, 16));
	notes.setBounds(10, 15, 205, 395);
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
	clockFrame.setSize(500, 575);
	clockFrame.setVisible(true);
	clockFrame.add(time);
	//set day
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
	// ---
	clockFrame.add(placeholder);
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

