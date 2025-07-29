import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class TeacherGUI implements ActionListener {
    private JFrame welcomeFrame, tutorFrame, lecturerFrame, gradeAssigmentFrame, setSalaryFrame;
    private JPanel welFrameLeft, welFrameLeftContent, welFrameRight, welFrameRightTop, welFrameRightBottom, mainTutor,tutorContentPanel, rightTutor, rightTutorTop, rightTutorBottom, mainLecturer, mainLecturerContent,rightLecturerTop, rightLecturerBottom, rightLecturer, mainGradeAssignment, rightGradeAssignment,rightSalary, mainSalary;
    private JTextField teacherIdFieldT, teacherNameFieldT, addressFieldT, workingTypeFieldT, employmentStatFieldT,teacherIdFieldL, teacherNameFieldL, addressFieldL, workingTypeFieldL, employmentStatFieldL,workingHoursFieldT, workingHoursFieldL, departmentField, yrsOfExperienceField, gradedScoreField,salaryField, specializationField, academicQualificationField, performanceIndexField, teacherIdGradeField,gradedScoreGradeField, departmentGradeField, yrsOfExperienceGradeField, teacherIdSalaryField,newSalaryField, performanceIndexSalaryField;
    private JButton addLecturer, addTutor, gradeAssignment, salarySet, removeTutor, displayT, clearT, displayL, clearL,asLecturer, asTutor, gradeAssignmentGradeButton, setSalaryButton, goBackTutor, goBackLecturer, goBackSalaryButton, goBackGradeButton;
    private JLabel mainImageLabel, imageLabel, welFrameHeading, logInHeader, teacherIdLabelT, teacherNameLabelT,addressLabelT, workingTypeLabelT, employmentStatLabelT, teacherIdLabelL, teacherNameLabelL, addressLabelL,workingTypeLabelL, employmentStatLabelL, workingHoursLabelT, workingHoursLabelL, departmentLabel,yrsOfExperienceLabel, gradedScoreLabel, salaryLabel, specializationLabel, academicQualificationLabel,performanceIndexLabel, headerGrade, teacherIdGradeLabel, gradedScoreGradeLabel, departmentGradeLabel,yrsOfExperienceGradeLabel, salaryHeader, teacherIdSalaryLabel, newSalaryLabel, performanceIndexSalaryLabel,addTutorImage, salarySetImage, removeTutorImage, displayTutorImage, clearTutorImage, addLecturerImage,gradeAssignmentImage, gradeAssignmentImageSmall, displayLecturerImage, clearLecturerImage, setSalaryImage, goBackImageTutor, goBackImageLecturer, goBackSalary, goBackGrade;
    private JTextArea welFrameCenter, headerT, headerL;
    ImageIcon userImage, mainImageIcon, tutorImageIcon, salarySetIcon, removeTutorIcon, displayTutorIcon,clearTutorIcon, addLecturerIcon, gradeAssignmentIcon, displayLecturerIcon, clearLecturerIcon, goBackIcon;

    ArrayList<Teacher> Teacher = new ArrayList<Teacher>();

    public TeacherGUI() {
        //Creating frames for the GUI
        //Creating Frame for the welcome page
        welcomeFrame = new JFrame("Welcome");

        //Creating Frame for the Tutor page
        tutorFrame = new JFrame("Tutors");

        //Creating Frame for the Lecturer page
        lecturerFrame = new JFrame("Lecturers");

        //Creating Frame for grading assignments
        gradeAssigmentFrame = new JFrame("Grade Assigments");

        //Creating Frame for setting salary
        setSalaryFrame = new JFrame("Set Salary");

        //Creating a Color object for text color and background
        Color secondaryColor = new Color(44, 62, 80);
        //Creating a Color onject for primary background color
        Color primaryColor = new Color(245, 245, 245);

        //Creating a Border object to remove borders
        Border emptyBorder = BorderFactory.createEmptyBorder();

        //Creating a Cursor object to change the cursor to pointer
        Cursor buttonCursor = new Cursor(Cursor.HAND_CURSOR);

        //Creating a Font object for main text in the GUI
        Font mainFont = new Font("Cambria", Font.PLAIN, 19);

        //Creating a Font object for headers 
        Font headerFont = new Font("Cambria", Font.BOLD, 22);

        //Creating a Font object for the larger headers
        Font homePageHeader = new Font("Cambria", Font.PLAIN, 50);

        //Code for the welcome frame GUI
        //Creating an ImageIcon for the Image used in the welcome page
        mainImageIcon = new ImageIcon(getClass().getResource("Icons/coverMain.png"));
        //Using JLabel to display the ImageIcon
        mainImageLabel = new JLabel(mainImageIcon);
        //setting bounds of the JLabel
        mainImageLabel.setBounds(0, 0, 802, 400);

        //Creating a JTextArea to display short description about the program
        welFrameCenter = new JTextArea("This is a advanced software in which you easily add, update, and remove tutors and lecturers Simplify the grading process with our intuitive assignment grading module. Tutors and lecturers can grade assignments online, providing feedback and evaluations in real-time. The system automatically calculates grades and generates reports for easy analysis.");
        welFrameCenter.setBounds(50, 550, 700, 150);
        welFrameCenter.setEditable(false);
        welFrameCenter.setLineWrap(true);
        welFrameCenter.setWrapStyleWord(true);
        welFrameCenter.setBackground(primaryColor);
        welFrameCenter.setForeground(secondaryColor);
        welFrameCenter.setFont(mainFont);

        //Creating a JLabel to display the Main header 
        welFrameHeading = new JLabel("Welcome to the Home Page");
        welFrameHeading.setBounds(50, 400, 700, 200);
        welFrameHeading.setFont(homePageHeader);
        welFrameHeading.setForeground(secondaryColor);

        //Creating a JLabel to display log in message
        logInHeader = new JLabel("Log In As:");
        logInHeader.setBounds(100, 0, 400, 60);
        logInHeader.setFont(homePageHeader);
        logInHeader.setForeground(primaryColor);

        //Creating a JButton to go to the Lecturer Frame
        asLecturer = new JButton("Lecturer");
        asLecturer.setBounds(125, 150, 150, 40);
        asLecturer.setPreferredSize(new Dimension(150, 40));
        asLecturer.setBackground(secondaryColor);
        asLecturer.setForeground(primaryColor);
        asLecturer.setFocusable(false);
        asLecturer.setFont(mainFont);
        //Adding a Mouse Listener, so that when hovering over the button the color changes
        asLecturer.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent ev) {
                    asLecturer.setBackground(primaryColor);
                    asLecturer.setForeground(secondaryColor);
                }

                public void mouseExited(MouseEvent ev) {
                    asLecturer.setBackground(secondaryColor);
                    asLecturer.setForeground(primaryColor);
                }
            });
        //Adding a Action Listener, so that when the button is pressed the Lecturer Frame is displayed
        asLecturer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    lecturerFrame.setVisible(true);
                    welcomeFrame.dispose();
                }
            });

        //Creating a JButton to open Tutor Frame
        asTutor = new JButton("Tutor");
        asTutor.setBounds(125, 220, 150, 40);
        asTutor.setPreferredSize(new Dimension(150, 40));
        asTutor.setBackground(secondaryColor);
        asTutor.setForeground(primaryColor);
        asTutor.setFocusable(false);
        asTutor.setFont(mainFont);
        //Adding a Mouse Listener, so that when hovering over the button the color changes
        asTutor.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent ev) {
                    asTutor.setBackground(primaryColor);
                    asTutor.setForeground(secondaryColor);
                }

                public void mouseExited(MouseEvent ev) {
                    asTutor.setBackground(secondaryColor);
                    asTutor.setForeground(primaryColor);
                }
            });
        //Adding a Action Listener, so that when the button is pressed the Tutor Frame is displayed
        asTutor.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    tutorFrame.setVisible(true);
                    welcomeFrame.dispose();
                }
            });

        //Creating an ImageIcon to display the User Image
        userImage = new ImageIcon(getClass().getResource("Icons/userIcon.png"));
        //Using JLabel to display the ImageIcon
        imageLabel = new JLabel(userImage);
        imageLabel.setBounds(0, 0, 400, 200);

        //JPanel for the Top right section of the GUI
        welFrameRightTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 190));
        welFrameRightTop.setBackground(secondaryColor);
        welFrameRightTop.add(imageLabel);

        //JPanel for the bottom right section of the GUI
        welFrameRightBottom = new JPanel(null);
        welFrameRightBottom.setBackground(secondaryColor);
        welFrameRightBottom.add(logInHeader);
        welFrameRightBottom.add(asLecturer);
        welFrameRightBottom.add(asTutor);

        //JPanel for the main content in the left section
        welFrameLeftContent = new JPanel();
        welFrameLeftContent.setLayout(null);
        welFrameLeftContent.setPreferredSize(new Dimension(800, 900));
        welFrameLeftContent.setBackground(primaryColor);
        welFrameLeftContent.add(mainImageLabel);
        welFrameLeftContent.add(welFrameHeading);
        welFrameLeftContent.add(welFrameCenter);

        //JPanel for the left section
        welFrameLeft = new JPanel();
        welFrameLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        welFrameLeft.setBackground(primaryColor);
        welFrameLeft.add(welFrameLeftContent);

        //JPanel for the right section
        welFrameRight = new JPanel();
        welFrameRight.setLayout(new GridLayout(2, 0));
        welFrameRight.setBackground(secondaryColor);
        welFrameRight.add(welFrameRightTop);
        welFrameRight.add(welFrameRightBottom);
        welFrameRight.setBounds(800, 0, 400, 900);

        //welcome Frame settingsL
        //setting the extendedState to MAXIMIZED to open the GUI in fullscreen
        welcomeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        welcomeFrame.setSize(1200, 900);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setVisible(true);
        welcomeFrame.setLayout(new BorderLayout());
        welcomeFrame.setResizable(true);
        welcomeFrame.add(welFrameLeft, BorderLayout.CENTER);
        welcomeFrame.add(welFrameRight, BorderLayout.EAST);

        // For Tutor Frame:
        //Header for the top right panel
        headerT = new JTextArea("Add, Remove and Set Salary for Tutors");
        headerT.setEditable(false);
        headerT.setLineWrap(true);
        headerT.setWrapStyleWord(true);
        headerT.setBackground(secondaryColor);
        headerT.setForeground(primaryColor);
        headerT.setFont(homePageHeader);
        headerT.setPreferredSize(new Dimension(400, 200));
        
        //JLabels for Tutor JFrame
        //JLabel for Teacher ID in Tutor Frame
        teacherIdLabelT = new JLabel("Teacher ID:");
        teacherIdLabelT.setBounds(200, 30, 100, 40);
        teacherIdLabelT.setForeground(secondaryColor);
        teacherIdLabelT.setFont(mainFont);

        //JLabel for Teacher Name in Tutor Frame
        teacherNameLabelT = new JLabel("Teacher Name: ");
        teacherNameLabelT.setBounds(200, 110, 190, 40);
        teacherNameLabelT.setForeground(secondaryColor);
        teacherNameLabelT.setFont(mainFont);

        //JLabel for Address in Tutor Frame
        addressLabelT = new JLabel("Address:");
        addressLabelT.setBounds(200, 190, 190, 40);
        addressLabelT.setForeground(secondaryColor);
        addressLabelT.setFont(mainFont);

        //JLabel for Working Type in Tutor Frame
        workingTypeLabelT = new JLabel("Working Type:");
        workingTypeLabelT.setBounds(200, 270, 190, 40);
        workingTypeLabelT.setForeground(secondaryColor);
        workingTypeLabelT.setFont(mainFont);

        //JLabel for Employment Status in Tutor Frame
        employmentStatLabelT = new JLabel("Employment Status:");
        employmentStatLabelT.setBounds(200, 350, 190, 40);
        employmentStatLabelT.setForeground(secondaryColor);
        employmentStatLabelT.setFont(mainFont);

        //JLabel for Working Hours in Tutor Frame
        workingHoursLabelT = new JLabel("Working Hours:");
        workingHoursLabelT.setBounds(200, 430, 190, 40);
        workingHoursLabelT.setForeground(secondaryColor);
        workingHoursLabelT.setFont(mainFont);

        //JLabel for Salary ID in Tutor Frame
        salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(200, 510, 190, 40);
        salaryLabel.setForeground(secondaryColor);
        salaryLabel.setFont(mainFont);

        //JLabel for Specialization ID in Tutor Frame
        specializationLabel = new JLabel("Specialization:");
        specializationLabel.setBounds(200, 590, 190, 40);
        specializationLabel.setForeground(secondaryColor);
        specializationLabel.setFont(mainFont);

        //JLabel for Academic Qualification in Tutor Frame
        academicQualificationLabel = new JLabel("Academic Qualification:");
        academicQualificationLabel.setBounds(200, 670, 190, 40);
        academicQualificationLabel.setForeground(secondaryColor);
        academicQualificationLabel.setFont(mainFont);

        //JLabel for Performance Index in Tutor Frame
        performanceIndexLabel = new JLabel("Performance Index:");
        performanceIndexLabel.setBounds(200, 750, 190, 40);
        performanceIndexLabel.setForeground(secondaryColor);
        performanceIndexLabel.setFont(mainFont);

        //JTextFields for Tutor Frame
        //JTextField for Teacher ID in Tutor Frame
        teacherIdFieldT = new JTextField();
        teacherIdFieldT.setBounds(200, 65, 400, 35);
        teacherIdFieldT.setBackground(primaryColor);
        teacherIdFieldT.setForeground(secondaryColor);
        teacherIdFieldT.setHorizontalAlignment(JTextField.CENTER);
        teacherIdFieldT.setFont(mainFont);

        //JTextField for Teacher Name in Tutor Frame
        teacherNameFieldT = new JTextField();
        teacherNameFieldT.setBounds(200, 145, 400, 35);
        teacherNameFieldT.setBackground(primaryColor);
        teacherNameFieldT.setForeground(secondaryColor);
        teacherNameFieldT.setHorizontalAlignment(JTextField.CENTER);
        teacherNameFieldT.setFont(mainFont);

        //JTextField for Address in Tutor Frame
        addressFieldT = new JTextField();
        addressFieldT.setBounds(200, 225, 400, 35);
        addressFieldT.setBackground(primaryColor);
        addressFieldT.setForeground(secondaryColor);
        addressFieldT.setHorizontalAlignment(JTextField.CENTER);
        addressFieldT.setFont(mainFont);

        //JTextField for Working Type in Tutor Frame
        workingTypeFieldT = new JTextField();
        workingTypeFieldT.setBounds(200, 305, 400, 35);
        workingTypeFieldT.setBackground(primaryColor);
        workingTypeFieldT.setForeground(secondaryColor);
        workingTypeFieldT.setHorizontalAlignment(JTextField.CENTER);
        workingTypeFieldT.setFont(mainFont);

        //JTextField for Employment Status in Tutor Frame
        employmentStatFieldT = new JTextField();
        employmentStatFieldT.setBounds(200, 385, 400, 35);
        employmentStatFieldT.setBackground(primaryColor);
        employmentStatFieldT.setForeground(secondaryColor);
        employmentStatFieldT.setHorizontalAlignment(JTextField.CENTER);
        employmentStatFieldT.setFont(mainFont);

        //JTextField for Working Hours in Tutor Frame
        workingHoursFieldT = new JTextField();
        workingHoursFieldT.setBounds(200, 465, 400, 35);
        workingHoursFieldT.setBackground(primaryColor);
        workingHoursFieldT.setForeground(secondaryColor);
        workingHoursFieldT.setHorizontalAlignment(JTextField.CENTER);
        workingHoursFieldT.setFont(mainFont);

        //JTextField for Salary in Tutor Frame
        salaryField = new JTextField();
        salaryField.setBounds(200, 545, 400, 35);
        salaryField.setBackground(primaryColor);
        salaryField.setForeground(secondaryColor);
        salaryField.setHorizontalAlignment(JTextField.CENTER);
        salaryField.setFont(mainFont);

        //JTextField for Specialization in Tutor Frame
        specializationField = new JTextField();
        specializationField.setBounds(200, 625, 400, 35);
        specializationField.setBackground(primaryColor);
        specializationField.setForeground(secondaryColor);
        specializationField.setHorizontalAlignment(JTextField.CENTER);
        specializationField.setFont(mainFont);

        //JTextField for Academic Qualification in Tutor Frame
        academicQualificationField = new JTextField();
        academicQualificationField.setBounds(200, 705, 400, 35);
        academicQualificationField.setBackground(primaryColor);
        academicQualificationField.setForeground(secondaryColor);
        academicQualificationField.setHorizontalAlignment(JTextField.CENTER);
        academicQualificationField.setFont(mainFont);

        //JTextField for Performance Index in Tutor Frame
        performanceIndexField = new JTextField();
        performanceIndexField.setBounds(200, 785, 400, 35);
        performanceIndexField.setBackground(primaryColor);
        performanceIndexField.setForeground(secondaryColor);
        performanceIndexField.setHorizontalAlignment(JTextField.CENTER);
        performanceIndexField.setFont(mainFont);

        //ImageIcon for Add Tutor Button
        tutorImageIcon = new ImageIcon(getClass().getResource("Icons/userIconMain.png"));
        addTutorImage = new JLabel(tutorImageIcon);
        addTutorImage.setBounds(250, 0, 40, 40);

        //ImageIcon for Set Salary Button
        salarySetIcon = new ImageIcon(getClass().getResource("Icons/salary.png"));
        salarySetImage = new JLabel(salarySetIcon);
        salarySetImage.setBounds(250, 80, 40, 40);

        //ImageIcon for Remove Tutor Button
        removeTutorIcon = new ImageIcon(getClass().getResource("Icons/remove.png"));
        removeTutorImage = new JLabel(removeTutorIcon);
        removeTutorImage.setBounds(250, 160, 40, 40);

        //ImageIcon for Display Button
        displayTutorIcon = new ImageIcon(getClass().getResource("Icons/display.png"));
        displayTutorImage = new JLabel(displayTutorIcon);
        displayTutorImage.setBounds(250, 240, 40, 40);

        //ImageIcon for Clear Button
        clearTutorIcon = new ImageIcon(getClass().getResource("Icons/clear.png"));
        clearTutorImage = new JLabel(clearTutorIcon);
        clearTutorImage.setBounds(250, 320, 40, 40);

        //ImageIcon for Go Back Button
        goBackIcon = new ImageIcon(getClass().getResource("Icons/goBack.png"));
        goBackImageTutor = new JLabel(goBackIcon);
        goBackImageTutor.setBounds(250, 400, 40, 40);

        //JButtons for Tutor Frame
        //JButton for Add Tutor in Tutor Frame
        addTutor = new JButton("Add Tutor");
        addTutor.setBounds(100, 0, 150, 40);
        addTutor.setFocusable(false);
        addTutor.setBorder(emptyBorder);
        addTutor.setCursor(buttonCursor);
        addTutor.setBackground(secondaryColor);
        addTutor.setForeground(primaryColor);
        addTutor.setFont(mainFont);
        addTutor.addActionListener(this);

        //JButton for Set Salary in Tutor Frame
        salarySet = new JButton("Set Salary");
        salarySet.setBounds(100, 80, 150, 40);
        salarySet.setFocusable(false);
        salarySet.setBorder(emptyBorder);
        salarySet.setCursor(buttonCursor);
        salarySet.setBackground(secondaryColor);
        salarySet.setForeground(primaryColor);
        salarySet.setFont(mainFont);
        salarySet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSalaryFrame.setVisible(true);
            }
        });

        //JButton for Remove Tutor in Tutor Frame
        removeTutor = new JButton("Remove Tutor");
        removeTutor.setBounds(100, 160, 150, 40);
        removeTutor.setFocusable(false);
        removeTutor.setBorder(emptyBorder);
        removeTutor.setCursor(buttonCursor);
        removeTutor.setBackground(secondaryColor);
        removeTutor.setForeground(primaryColor);
        removeTutor.setFont(mainFont);
        removeTutor.addActionListener(this);

        //JButton for Display in Tutor Frame
        displayT = new JButton("Display");
        displayT.setBounds(100, 240, 150, 40);
        displayT.setFocusable(false);
        displayT.setBorder(emptyBorder);
        displayT.setCursor(buttonCursor);
        displayT.setBackground(secondaryColor);
        displayT.setForeground(primaryColor);
        displayT.setFont(mainFont);
        displayT.addActionListener(this);

        //JButton for Clear in Tutor Frame
        clearT = new JButton("Clear");
        clearT.setBounds(100, 320, 150, 40);
        clearT.setFocusable(false);
        clearT.setCursor(buttonCursor);
        clearT.setBorder(emptyBorder);
        clearT.addActionListener(this);
        clearT.setBackground(secondaryColor);
        clearT.setForeground(primaryColor);
        clearT.setFont(mainFont);

        //JButton for Go Back in Tutor Frame
        goBackTutor = new JButton("Go Back");
        goBackTutor.setBounds(100, 400, 150, 40);
        goBackTutor.setFocusable(false);
        goBackTutor.setCursor(buttonCursor);
        goBackTutor.setBorder(emptyBorder);
        goBackTutor.setBackground(secondaryColor);
        goBackTutor.setForeground(primaryColor);
        goBackTutor.setFont(mainFont);
        goBackTutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tutorFrame.setVisible(false);
                welcomeFrame.setVisible(true);
            }
        });

        //JPanel for the main contents
        tutorContentPanel = new JPanel(null);
        tutorContentPanel.setBackground(primaryColor);
        tutorContentPanel.setPreferredSize(new Dimension(800, 900));

        //JPanel for the Top right section for Header
        rightTutorTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 200));
        rightTutorTop.setBackground(secondaryColor);

        //JPanel for the Bottom right section for JButtons
        rightTutorBottom = new JPanel(null);
        rightTutorBottom.setBackground(secondaryColor);

        //JPanel for the left section of the GUI
        mainTutor = new JPanel(new FlowLayout());
        mainTutor.setBackground(primaryColor);

        //JPanel for the right section of the GUI
        rightTutor = new JPanel(new GridLayout(2, 0));
        rightTutor.setBackground(secondaryColor);

        //Adding all the JLabels
        tutorContentPanel.add(teacherIdLabelT);
        tutorContentPanel.add(teacherNameLabelT);
        tutorContentPanel.add(addressLabelT);
        tutorContentPanel.add(workingTypeLabelT);
        tutorContentPanel.add(employmentStatLabelT);
        tutorContentPanel.add(workingHoursLabelT);
        tutorContentPanel.add(salaryLabel);
        tutorContentPanel.add(specializationLabel);
        tutorContentPanel.add(academicQualificationLabel);
        tutorContentPanel.add(performanceIndexLabel);

        //Adding all the JTextFields
        tutorContentPanel.add(teacherIdFieldT);
        tutorContentPanel.add(teacherNameFieldT);
        tutorContentPanel.add(addressFieldT);
        tutorContentPanel.add(workingTypeFieldT);
        tutorContentPanel.add(employmentStatFieldT);
        tutorContentPanel.add(workingHoursFieldT);
        tutorContentPanel.add(performanceIndexField);
        tutorContentPanel.add(academicQualificationField);
        tutorContentPanel.add(specializationField);
        tutorContentPanel.add(salaryField);

        //Adding header in the top right JPanel
        rightTutorTop.add(headerT);

        //Adding JButtons in the bottom right JPanel
        rightTutorBottom.add(addTutorImage);
        rightTutorBottom.add(salarySetImage);
        rightTutorBottom.add(removeTutorImage);
        rightTutorBottom.add(displayTutorImage);
        rightTutorBottom.add(clearTutorImage);
        rightTutorBottom.add(goBackImageTutor);

        //Adding ImageIcons in the bottom right JPanel
        rightTutorBottom.add(addTutor);
        rightTutorBottom.add(salarySet);
        rightTutorBottom.add(removeTutor);
        rightTutorBottom.add(displayT);
        rightTutorBottom.add(clearT);
        rightTutorBottom.add(goBackTutor);

        //Adding Top JPanel and Bottom JPanel in right section
        rightTutor.add(rightTutorTop);
        rightTutor.add(rightTutorBottom);

        //Adding the main content panel in the Left JPanel
        mainTutor.add(tutorContentPanel);

        //Configuring the tutor JFrame
        tutorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tutorFrame.setSize(1200, 900);
        tutorFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        tutorFrame.setLayout(new BorderLayout());
        tutorFrame.add(mainTutor, BorderLayout.CENTER);
        tutorFrame.add(rightTutor, BorderLayout.EAST);

        // For Lecturer Frame:
        //Header for the top right JPanel
        headerL = new JTextArea("Add Lecturers and Grade Assignments");
        headerL.setEditable(false);
        headerL.setLineWrap(true);
        headerL.setWrapStyleWord(true);
        headerL.setBackground(secondaryColor);
        headerL.setForeground(primaryColor);
        headerL.setFont(homePageHeader);
        headerL.setPreferredSize(new Dimension(400, 200));

        //JLabels for Lecturer JFrame
        //JLabel for Teacher Id in Lecturer Frame
        teacherIdLabelL = new JLabel("Teacher ID:");
        teacherIdLabelL.setBounds(200, 50, 190, 40);
        teacherIdLabelL.setForeground(secondaryColor);
        teacherIdLabelL.setFont(mainFont);

        //JLabel for Teacher Name in Lecturer Frame
        teacherNameLabelL = new JLabel("Teacher Name: ");
        teacherNameLabelL.setBounds(200, 130, 190, 40);
        teacherNameLabelL.setForeground(secondaryColor);
        teacherNameLabelL.setFont(mainFont);

        //JLabel for Address in Lecturer Frame
        addressLabelL = new JLabel("Address:");
        addressLabelL.setBounds(200, 210, 190, 40);
        addressLabelL.setForeground(secondaryColor);
        addressLabelL.setFont(mainFont);

        //JLabel for Working Type in Lecturer Frame
        workingTypeLabelL = new JLabel("Working Type:");
        workingTypeLabelL.setBounds(200, 290, 190, 40);
        workingTypeLabelL.setForeground(secondaryColor);
        workingTypeLabelL.setFont(mainFont);

        //JLabel for Employment Status in Lecturer Frame
        employmentStatLabelL = new JLabel("Employment Status:");
        employmentStatLabelL.setBounds(200, 370, 190, 40);
        employmentStatLabelL.setForeground(secondaryColor);
        employmentStatLabelL.setFont(mainFont);

        //JLabel for Years of Experience in Lecturer Frame
        yrsOfExperienceLabel = new JLabel("Years of Experience:");
        yrsOfExperienceLabel.setBounds(200, 450, 190, 40);
        yrsOfExperienceLabel.setForeground(secondaryColor);
        yrsOfExperienceLabel.setFont(mainFont);

        //JLabel for Graded Score in Lecturer Frame
        gradedScoreLabel = new JLabel("Graded Score:");
        gradedScoreLabel.setBounds(200, 530, 190, 40);
        gradedScoreLabel.setForeground(secondaryColor);
        gradedScoreLabel.setFont(mainFont);

        //JLabel for Department in Lecturer Frame
        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(200, 610, 190, 40);
        departmentLabel.setForeground(secondaryColor);
        departmentLabel.setFont(mainFont);

        //JLabel for Working Hours in Lecturer Frame
        workingHoursLabelL = new JLabel("Working Hours:");
        workingHoursLabelL.setBounds(200, 690, 190, 40);
        workingHoursLabelL.setForeground(secondaryColor);
        workingHoursLabelL.setFont(mainFont);

        //JTextFields for the Lecturer JFrame
        //JTextField for Teacher ID in Lecturer Frame
        teacherIdFieldL = new JTextField();
        teacherIdFieldL.setBounds(200, 85, 400, 40);
        teacherIdFieldL.setBackground(primaryColor);
        teacherIdFieldL.setForeground(secondaryColor);
        teacherIdFieldL.setHorizontalAlignment(JTextField.CENTER);
        teacherIdFieldL.setFont(mainFont);

        //JTextField for Teacher Name in Lecturer Frame
        teacherNameFieldL = new JTextField();
        teacherNameFieldL.setBounds(200, 165, 400, 40);
        teacherNameFieldL.setBackground(primaryColor);
        teacherNameFieldL.setForeground(secondaryColor);
        teacherNameFieldL.setHorizontalAlignment(JTextField.CENTER);
        teacherNameFieldL.setFont(mainFont);

        //JTextField for Address in Lecturer Frame
        addressFieldL = new JTextField();
        addressFieldL.setBounds(200, 245, 400, 40);
        addressFieldL.setBackground(primaryColor);
        addressFieldL.setForeground(secondaryColor);
        addressFieldL.setHorizontalAlignment(JTextField.CENTER);
        addressFieldL.setFont(mainFont);

        //JTextField for Working Type in Lecturer Frame
        workingTypeFieldL = new JTextField();
        workingTypeFieldL.setBounds(200, 325, 400, 40);
        workingTypeFieldL.setBackground(primaryColor);
        workingTypeFieldL.setForeground(secondaryColor);
        workingTypeFieldL.setHorizontalAlignment(JTextField.CENTER);
        workingTypeFieldL.setFont(mainFont);

        //JTextField for Employment Status in Lecturer Frame
        employmentStatFieldL = new JTextField();
        employmentStatFieldL.setBounds(200, 405, 400, 40);
        employmentStatFieldL.setBackground(primaryColor);
        employmentStatFieldL.setForeground(secondaryColor);
        employmentStatFieldL.setHorizontalAlignment(JTextField.CENTER);
        employmentStatFieldL.setFont(mainFont);

        //JTextField for Years of Experience in Lecturer Frame
        yrsOfExperienceField = new JTextField();
        yrsOfExperienceField.setBounds(200, 485, 400, 40);
        yrsOfExperienceField.setBackground(primaryColor);
        yrsOfExperienceField.setForeground(secondaryColor);
        yrsOfExperienceField.setHorizontalAlignment(JTextField.CENTER);
        yrsOfExperienceField.setFont(mainFont);

        //JTextField for Graded Score in Lecturer Frame
        gradedScoreField = new JTextField();
        gradedScoreField.setBounds(200, 565, 400, 40);
        gradedScoreField.setBackground(primaryColor);
        gradedScoreField.setForeground(secondaryColor);
        gradedScoreField.setHorizontalAlignment(JTextField.CENTER);
        gradedScoreField.setFont(mainFont);

        //JTextField for Department in Lecturer Frame
        departmentField = new JTextField();
        departmentField.setBounds(200, 645, 400, 40);
        departmentField.setBackground(primaryColor);
        departmentField.setForeground(secondaryColor);
        departmentField.setHorizontalAlignment(JTextField.CENTER);
        departmentField.setFont(mainFont);

        //JTextField for Working Hours in Lecturer Frame
        workingHoursFieldL = new JTextField();
        workingHoursFieldL.setBounds(200, 725, 400, 40);
        workingHoursFieldL.setBackground(primaryColor);
        workingHoursFieldL.setForeground(secondaryColor);
        workingHoursFieldL.setHorizontalAlignment(JTextField.CENTER);
        workingHoursFieldL.setFont(mainFont);

        //Adding ImageIcons in the Lecturer Frame
        //ImageIcon for Add Lecturer Button
        addLecturerIcon = new ImageIcon(getClass().getResource("Icons/userIconMain.png"));
        addLecturerImage = new JLabel(addLecturerIcon);
        addLecturerImage.setBounds(250, 20, 40, 40);

        //ImageIcon for Grade Assignment Button
        gradeAssignmentIcon = new ImageIcon(getClass().getResource("Icons/gradeAssignment.png"));
        gradeAssignmentImage = new JLabel(gradeAssignmentIcon);
        gradeAssignmentImage.setBounds(250, 100, 40, 40);

        //ImageIcon for Display Button
        displayLecturerIcon = new ImageIcon(getClass().getResource("Icons/display.png"));
        displayLecturerImage = new JLabel(displayLecturerIcon);
        displayLecturerImage.setBounds(250, 180, 40, 40);

        //ImageIcon for Clear Button
        clearLecturerIcon = new ImageIcon(getClass().getResource("Icons/clear.png"));
        clearLecturerImage = new JLabel(clearLecturerIcon);
        clearLecturerImage.setBounds(250, 260, 40, 40);

        //ImageIcon for Go Back Button
        goBackImageLecturer = new JLabel(goBackIcon);
        goBackImageLecturer.setBounds(250, 340, 40, 40);

        //JButtons for the Lecturer Frame
        //JButton for Add Lecturer
        addLecturer = new JButton("Add Lecturer");
        addLecturer.setBounds(100, 20, 150, 40);
        addLecturer.setFocusable(false);
        addLecturer.setBorder(emptyBorder);
        addLecturer.setCursor(buttonCursor);
        addLecturer.setBackground(secondaryColor);
        addLecturer.setForeground(primaryColor);
        addLecturer.setFont(mainFont);
        addLecturer.addActionListener(this);

        //JButton for Grade Assignment
        gradeAssignment = new JButton("Grade Assignment");
        gradeAssignment.setBounds(60, 100, 190, 40);
        gradeAssignment.setFocusable(false);
        gradeAssignment.setBorder(emptyBorder);
        gradeAssignment.setCursor(buttonCursor);
        gradeAssignment.setBackground(secondaryColor);
        gradeAssignment.setForeground(primaryColor);
        gradeAssignment.setFont(mainFont);
        gradeAssignment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gradeAssigmentFrame.setVisible(true);
            }
        });

        //JButton for Display button
        displayL = new JButton("Display");
        displayL.setBounds(100, 180, 150, 40);
        displayL.setFocusable(false);
        displayL.setBorder(emptyBorder);
        displayL.setCursor(buttonCursor);
        displayL.setBackground(secondaryColor);
        displayL.setForeground(primaryColor);
        displayL.setFont(mainFont);
        displayL.addActionListener(this);

        //JButton for Clear button
        clearL = new JButton("Clear");
        clearL.setFocusable(false);
        clearL.setBounds(100, 260, 150, 40);
        clearL.setBorder(emptyBorder);
        clearL.setCursor(buttonCursor);
        clearL.addActionListener(this);
        clearL.setBackground(secondaryColor);
        clearL.setForeground(primaryColor);
        clearL.setFont(mainFont);

        //JButton for Go Back 
        goBackLecturer = new JButton("Go Back");
        goBackLecturer.setBounds(100, 340, 150, 40);
        goBackLecturer.setFocusable(false);
        goBackLecturer.setCursor(buttonCursor);
        goBackLecturer.setBorder(emptyBorder);
        goBackLecturer.setBackground(secondaryColor);
        goBackLecturer.setForeground(primaryColor);
        goBackLecturer.setFont(mainFont);
        goBackLecturer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                lecturerFrame.setVisible(false);
                welcomeFrame.setVisible(true);
            }
        });

        //JPanel for main content 
        mainLecturerContent = new JPanel(null);
        mainLecturerContent.setBackground(primaryColor);
        mainLecturerContent.setPreferredSize(new Dimension(800, 900));

        //JPanel for the top right section
        rightLecturerTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 200));
        rightLecturerTop.setBackground(secondaryColor);

        //JPanel for the bottom right section
        rightLecturerBottom = new JPanel(null);
        rightLecturerBottom.setBackground(secondaryColor);
        
        //JPanel for the left section of the GUI
        mainLecturer = new JPanel(new FlowLayout());
        mainLecturer.setBackground(primaryColor);

        //JPanel for the right section of the GUI
        rightLecturer = new JPanel(new GridLayout(2, 0));
        rightLecturer.setBackground(secondaryColor);

        //Adding all the JLabels 
        mainLecturerContent.add(teacherIdLabelL);
        mainLecturerContent.add(teacherNameLabelL);
        mainLecturerContent.add(addressLabelL);
        mainLecturerContent.add(workingTypeLabelL);
        mainLecturerContent.add(employmentStatLabelL);
        mainLecturerContent.add(yrsOfExperienceLabel);
        mainLecturerContent.add(gradedScoreLabel);
        mainLecturerContent.add(departmentLabel);
        mainLecturerContent.add(workingHoursLabelL);

        //Adding all the JTextFields
        mainLecturerContent.add(teacherIdFieldL);
        mainLecturerContent.add(teacherNameFieldL);
        mainLecturerContent.add(addressFieldL);
        mainLecturerContent.add(workingTypeFieldL);
        mainLecturerContent.add(employmentStatFieldL);
        mainLecturerContent.add(yrsOfExperienceField);
        mainLecturerContent.add(gradedScoreField);
        mainLecturerContent.add(departmentField);
        mainLecturerContent.add(workingHoursFieldL);

        //Adding all the ImageIcons 
        rightLecturerBottom.add(addLecturerImage);
        rightLecturerBottom.add(gradeAssignmentImage);
        rightLecturerBottom.add(displayLecturerImage);
        rightLecturerBottom.add(clearLecturerImage);
        rightLecturerBottom.add(goBackImageLecturer);

        //Adding all the JButtons
        rightLecturerBottom.add(addLecturer);
        rightLecturerBottom.add(gradeAssignment);
        rightLecturerBottom.add(displayL);
        rightLecturerBottom.add(clearL);
        rightLecturerBottom.add(goBackLecturer);

        //Adding header in the top right section
        rightLecturerTop.add(headerL);

        //Adding the main content JPanel in the left section
        mainLecturer.add(mainLecturerContent);

        //Adding the Top JPanel and Bottom JPanel in the right section
        rightLecturer.add(rightLecturerTop);
        rightLecturer.add(rightLecturerBottom);

        //Configuring the Lecturer Frame
        lecturerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        lecturerFrame.setSize(1200, 900);
        lecturerFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        lecturerFrame.setLayout(new BorderLayout());
        lecturerFrame.add(mainLecturer, BorderLayout.CENTER);
        lecturerFrame.add(rightLecturer, BorderLayout.EAST);

        // for Grade Assigment Frame
        //Header for the Grade Assignment Frame
        headerGrade = new JLabel("Grade Assignments");
        headerGrade.setBounds(50, 100, 250, 40);
        headerGrade.setForeground(primaryColor);
        headerGrade.setFont(headerFont);

        //JLabels for Grade Assignment Frame
        //JLabel for Teacher ID in Grade Assignment Frame
        teacherIdGradeLabel = new JLabel("Teacher ID:");
        teacherIdGradeLabel.setBounds(50, 50, 190, 40);
        teacherIdGradeLabel.setForeground(secondaryColor);
        teacherIdGradeLabel.setFont(mainFont);

        //JLabel for Graded Score in Grade Assignment Frame
        gradedScoreGradeLabel = new JLabel("Graded Score:");
        gradedScoreGradeLabel.setBounds(50, 130, 190, 40);
        gradedScoreGradeLabel.setForeground(secondaryColor);
        gradedScoreGradeLabel.setFont(mainFont);

        //JLabel for Department in Grade Assignment Frame
        departmentGradeLabel = new JLabel("Department:");
        departmentGradeLabel.setBounds(50, 210, 190, 40);
        departmentGradeLabel.setForeground(secondaryColor);
        departmentGradeLabel.setFont(mainFont);

        //JLabel for Years of Experience in Grade Assignment Frame
        yrsOfExperienceGradeLabel = new JLabel("Years of Experience: ");
        yrsOfExperienceGradeLabel.setBounds(50, 290, 190, 40);
        yrsOfExperienceGradeLabel.setBackground(primaryColor);
        yrsOfExperienceGradeLabel.setForeground(secondaryColor);
        yrsOfExperienceGradeLabel.setHorizontalAlignment(JTextField.CENTER);
        yrsOfExperienceGradeLabel.setFont(mainFont);

        //JTextFields for Grade Assignment Frame
        //JTextField for Teacher ID in Grade Assignment Frame
        teacherIdGradeField = new JTextField();
        teacherIdGradeField.setBounds(50, 85, 200, 40);
        teacherIdGradeField.setBackground(primaryColor);
        teacherIdGradeField.setForeground(secondaryColor);
        teacherIdGradeField.setHorizontalAlignment(JTextField.CENTER);
        teacherIdGradeField.setFont(mainFont);

        //JTextField for Graded Score in Grade Assignment Frame
        gradedScoreGradeField = new JTextField();
        gradedScoreGradeField.setBounds(50, 165, 200, 40);
        gradedScoreGradeField.setBackground(primaryColor);
        gradedScoreGradeField.setForeground(secondaryColor);
        gradedScoreGradeField.setHorizontalAlignment(JTextField.CENTER);
        gradedScoreGradeField.setFont(mainFont);

        //JTextField for Department in Grade Assignment Frame
        departmentGradeField = new JTextField();
        departmentGradeField.setBounds(50, 245, 200, 40);
        departmentGradeField.setBackground(primaryColor);
        departmentGradeField.setForeground(secondaryColor);
        departmentGradeField.setHorizontalAlignment(JTextField.CENTER);
        departmentGradeField.setFont(mainFont);

        //JTextField for Years of Experience in Grade Assignment Frame
        yrsOfExperienceGradeField = new JTextField();
        yrsOfExperienceGradeField.setBounds(50, 325, 200, 40);
        yrsOfExperienceGradeField.setBackground(primaryColor);
        yrsOfExperienceGradeField.setForeground(secondaryColor);
        yrsOfExperienceGradeField.setHorizontalAlignment(JTextField.CENTER);
        yrsOfExperienceGradeField.setFont(mainFont);

        //JLabel for adding ImageIcon 
        gradeAssignmentImageSmall = new JLabel(gradeAssignmentIcon);
        gradeAssignmentImageSmall.setBounds(220, 185, 40, 40);

        //JLabel for adding ImageIcon 
        goBackGrade = new JLabel(goBackIcon);
        goBackGrade.setBounds(220, 265, 40, 40);

        //JButtons for Grade Assignment Frame
        //JButton for Grade Assignment 
        gradeAssignmentGradeButton = new JButton("Grade Assignment");
        gradeAssignmentGradeButton.setBounds(30, 185, 190, 40);
        gradeAssignmentGradeButton.setFocusable(false);
        gradeAssignmentGradeButton.setBorder(emptyBorder);
        gradeAssignmentGradeButton.setBackground(secondaryColor);
        gradeAssignmentGradeButton.setForeground(primaryColor);
        gradeAssignmentGradeButton.setFont(mainFont);
        gradeAssignmentGradeButton.addActionListener(this);

        //JButton for Go Back
        goBackGradeButton = new JButton("Go Back");
        goBackGradeButton.setBounds(30, 265, 190, 40);
        goBackGradeButton.setFocusable(false);
        goBackGradeButton.setBorder(emptyBorder);
        goBackGradeButton.setBackground(secondaryColor);
        goBackGradeButton.setForeground(primaryColor);
        goBackGradeButton.setFont(mainFont);
        goBackGradeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                gradeAssigmentFrame.dispose();
            }
        });

        //Creating a JPanel for the left side of the frame
        mainGradeAssignment = new JPanel();
        mainGradeAssignment.setBounds(0, 0, 300, 450);
        mainGradeAssignment.setBackground(primaryColor);
        mainGradeAssignment.setLayout(null);

        //creating a JPanel for the right side of the panel
        rightGradeAssignment = new JPanel();
        rightGradeAssignment.setBounds(300, 0, 300, 450);
        rightGradeAssignment.setBackground(secondaryColor);
        rightGradeAssignment.setLayout(null);

        //Adding all the labels in the panel
        mainGradeAssignment.add(teacherIdGradeLabel);
        mainGradeAssignment.add(gradedScoreGradeLabel);
        mainGradeAssignment.add(departmentGradeLabel);
        mainGradeAssignment.add(yrsOfExperienceGradeLabel);

        //Adding all the TextFields in the panel
        mainGradeAssignment.add(teacherIdGradeField);
        mainGradeAssignment.add(gradedScoreGradeField);
        mainGradeAssignment.add(departmentGradeField);
        mainGradeAssignment.add(yrsOfExperienceGradeField);

        //Adding the ImageIcon  
        rightGradeAssignment.add(gradeAssignmentImageSmall);
        rightGradeAssignment.add(goBackGrade);

        //Adding the buttons and the header
        rightGradeAssignment.add(headerGrade);
        rightGradeAssignment.add(gradeAssignmentGradeButton);
        rightGradeAssignment.add(goBackGradeButton);

        //Configuring the Grade Assignment Frame
        gradeAssigmentFrame.setSize(600, 450);
        gradeAssigmentFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        gradeAssigmentFrame.setLayout(null);
        gradeAssigmentFrame.setResizable(false);
        gradeAssigmentFrame.add(mainGradeAssignment);
        gradeAssigmentFrame.add(rightGradeAssignment);

        // for Set Salary Frame
        //Header for set salary frame
        salaryHeader = new JLabel("Set Salary");
        salaryHeader.setBounds(90, 100, 250, 40);
        salaryHeader.setForeground(primaryColor);
        salaryHeader.setFont(headerFont);

        //JLabel for Teacher ID
        teacherIdSalaryLabel = new JLabel("Teacher ID:");
        teacherIdSalaryLabel.setBounds(50, 70, 190, 40);
        teacherIdSalaryLabel.setForeground(secondaryColor);
        teacherIdSalaryLabel.setFont(mainFont);

        //JLabel for Salary
        newSalaryLabel = new JLabel("Salary:");
        newSalaryLabel.setBounds(50, 150, 190, 40);
        newSalaryLabel.setForeground(secondaryColor);
        newSalaryLabel.setFont(mainFont);

        //JLabel for Performance Index
        performanceIndexSalaryLabel = new JLabel("Performance Index:");
        performanceIndexSalaryLabel.setBounds(50, 230, 190, 40);
        performanceIndexSalaryLabel.setForeground(secondaryColor);
        performanceIndexSalaryLabel.setFont(mainFont);

        //ImageIcon for Set salary button
        setSalaryImage = new JLabel(salarySetIcon);
        setSalaryImage.setBounds(180, 185, 40, 40);

        //ImageIcon for go back button
        goBackSalary = new JLabel(goBackIcon);
        goBackSalary.setBounds(180, 265, 40, 40);

        //JTextField for Teacher ID
        teacherIdSalaryField = new JTextField();
        teacherIdSalaryField.setBounds(50, 105, 200, 40);
        teacherIdSalaryField.setBackground(primaryColor);
        teacherIdSalaryField.setForeground(secondaryColor);
        teacherIdSalaryField.setHorizontalAlignment(JTextField.CENTER);
        teacherIdSalaryField.setFont(mainFont);

        //JTextField for salary
        newSalaryField = new JTextField();
        newSalaryField.setBounds(50, 185, 200, 40);
        newSalaryField.setBackground(primaryColor);
        newSalaryField.setForeground(secondaryColor);
        newSalaryField.setHorizontalAlignment(JTextField.CENTER);
        newSalaryField.setFont(mainFont);

        //JTextField for Performance Index
        performanceIndexSalaryField = new JTextField();
        performanceIndexSalaryField.setBounds(50, 265, 200, 40);
        performanceIndexSalaryField.setBackground(primaryColor);
        performanceIndexSalaryField.setForeground(secondaryColor);
        performanceIndexSalaryField.setHorizontalAlignment(JTextField.CENTER);
        performanceIndexSalaryField.setFont(mainFont);

        //JButton for set salary
        setSalaryButton = new JButton("Set Salary");
        setSalaryButton.setBounds(30, 185, 150, 40);
        setSalaryButton.setFocusable(false);
        setSalaryButton.setBorder(emptyBorder);
        setSalaryButton.setCursor(buttonCursor);
        setSalaryButton.setBackground(secondaryColor);
        setSalaryButton.setForeground(primaryColor);
        setSalaryButton.setFont(mainFont);
        setSalaryButton.addActionListener(this);

        //JButton for go back
        goBackSalaryButton = new JButton("Go Back");
        goBackSalaryButton.setBounds(30, 265, 150, 40);
        goBackSalaryButton.setFocusable(false);
        goBackSalaryButton.setBorder(emptyBorder);
        goBackSalaryButton.setCursor(buttonCursor);
        goBackSalaryButton.setBackground(secondaryColor);
        goBackSalaryButton.setForeground(primaryColor);
        goBackSalaryButton.setFont(mainFont);
        goBackSalaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setSalaryFrame.dispose();
            }
        });

        //left side panel
        mainSalary = new JPanel();
        mainSalary.setBackground(primaryColor);
        mainSalary.setBounds(0, 0, 300, 450);
        mainSalary.setLayout(null);

        //right side panel
        rightSalary = new JPanel();
        rightSalary.setBackground(secondaryColor);
        rightSalary.setBounds(300, 0, 300, 450);
        rightSalary.setLayout(null);

        //adding the labels in the panel
        mainSalary.add(teacherIdSalaryLabel);
        mainSalary.add(newSalaryLabel);
        mainSalary.add(performanceIndexSalaryLabel);

        //adding the text fields in the panel
        mainSalary.add(teacherIdSalaryField);
        mainSalary.add(newSalaryField);
        mainSalary.add(performanceIndexSalaryField);

        //adding the imageicons and buttons in the panel
        rightSalary.add(setSalaryImage);
        rightSalary.add(setSalaryButton);
        rightSalary.add(salaryHeader);
        rightSalary.add(goBackSalaryButton);
        rightSalary.add(goBackSalary);

        //Configuring the set salary frame
        setSalaryFrame.setSize(600, 450);
        setSalaryFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSalaryFrame.setLayout(null);
        setSalaryFrame.setResizable(false);
        setSalaryFrame.add(mainSalary);
        setSalaryFrame.add(rightSalary);
    }

    //Method to detect an event when a button is pressed
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addTutor){
            //Getting all the text field values which are String
            String teacherName = teacherNameFieldT.getText();
            String address = addressFieldT.getText();
            String workingType = workingTypeFieldT.getText();
            String employmentStat = employmentStatFieldT.getText();
            String academicQualification = academicQualificationField.getText();
            String specialization = specializationField.getText();
            //Checking if any textfield is empty
            if(teacherName.isEmpty() || address.isEmpty() || workingType.isEmpty() || employmentStat.isEmpty() || academicQualification.isEmpty() || specialization.isEmpty()){
                JOptionPane.showMessageDialog(tutorFrame, "Fields are empty\nFill in all the fields and try again", "Empty Fields", JOptionPane.ERROR_MESSAGE);
            }else{
                //Try Catch to handle exceptions
                try{
                    //getting all the text field values which are integers or double
                    int teacherID = Integer.parseInt(teacherIdFieldT.getText());
                    double salary = Double.parseDouble(salaryField.getText());
                    int performanceIndex = Integer.parseInt(performanceIndexField.getText());
                    int workingHours = Integer.parseInt(workingHoursFieldT.getText());

                    //Conditions to add a tutor
                    if(salary < 0){
                        JOptionPane.showMessageDialog(tutorFrame, "Salary cannot be lower than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    }else if(performanceIndex < 0 || performanceIndex > 10){
                        JOptionPane.showMessageDialog(tutorFrame, "Performance Index must be less than 10 and greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    }else if(workingHours < 20 || workingHours > 70){
                        JOptionPane.showMessageDialog(tutorFrame, "Working Hours must be greater than 20 and less than 70", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        Tutor tutors = new Tutor(teacherID, teacherName, address, workingType, employmentStat, workingHours, salary, specialization, academicQualification, performanceIndex);

                        //Flag variable
                        boolean isAdded = false;

                        //Checking if the Array List is empty or not
                        if(Teacher.size() > 0){
                            //Iterating through the Array List using for-each loop
                            for(Teacher tutorObj : Teacher){
                                //checking if the object is an instance of Tutor class and if the ID match
                                if(tutorObj instanceof Tutor && teacherID == tutorObj.getID()){
                                    //changing the flag variable
                                    isAdded = true;
                                    //breaking the loop if the tutor is already added
                                    break;
                                }
                            }
                            //if tutor is already added show an error message if not added then creating a new tutor object and adding to the Array List
                            if(isAdded == true){
                                JOptionPane.showMessageDialog(tutorFrame, "Tutor with this ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                Teacher.add(tutors);
                                JOptionPane.showMessageDialog(tutorFrame, "Tutor added", "Add Tutor", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{//if Array List is empty then creating a new tutor object and adding to the Array List
                            Teacher.add(tutors);
                            JOptionPane.showMessageDialog(tutorFrame, "Tutor added", "Add Tutor", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                }catch(NumberFormatException exp){
                    JOptionPane.showMessageDialog(tutorFrame, "Teacher ID, Working Hours, Salary and Performance Index must be an Integer", "Exception", JOptionPane.ERROR_MESSAGE);
                }
            }

        }else if(e.getSource() == addLecturer){
            //Extracting values for JTextFields for String data type
            String teacherName = teacherNameFieldL.getText();
            String address = addressFieldL.getText();
            String workingType = workingTypeFieldL.getText();
            String employmentStat = employmentStatFieldL.getText();
            String department = departmentField.getText();
            //Checking if any of the JTextFields are empty
            if(teacherName.isEmpty() || address.isEmpty() || workingType.isEmpty() || employmentStat.isEmpty() || department.isEmpty()){
                JOptionPane.showMessageDialog(lecturerFrame, "Fields are empty\nFill in all the fields and try again" , "Empty Fields", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    //Extracting all the values from JTextFields for Int data type
                    int teacherID = Integer.parseInt(teacherIdFieldL.getText());
                    int yrsOfExperience = Integer.parseInt(yrsOfExperienceField.getText());
                    int gradedScore = Integer.parseInt(gradedScoreField.getText());
                    int workingHours = Integer.parseInt(workingHoursFieldL.getText()); 

                    //Displaying an error if these conditions are not met
                    if(yrsOfExperience < 5 || yrsOfExperience > 30){
                        JOptionPane.showMessageDialog(tutorFrame, "Years of Experience must be greater than 5 and less than 30", "Error", JOptionPane.ERROR_MESSAGE);
                    }else if(gradedScore < 0 || gradedScore > 100){
                        JOptionPane.showMessageDialog(tutorFrame, "Graded Score must be between 0 and 100", "Error", JOptionPane.ERROR_MESSAGE);
                    }else if(workingHours < 0 || workingHours > 50){
                        JOptionPane.showMessageDialog(tutorFrame, "Working Hours must be between 0 and 50", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        //Creating a new Lecturer object
                        Lecturer lecturers = new Lecturer(department, yrsOfExperience, teacherName, teacherID, address, workingType, employmentStat, workingHours);
                        
                        //Flag variable
                        boolean isAdded = false;

                        //Checking if the arraylist is empty or not
                        if(Teacher.size() > 0){
                            //iterating through the ArrayList
                            for(Teacher lecturerObj : Teacher){
                                //checking if the object is an instance of Lecturer and if the teacher id matches
                                if(lecturerObj instanceof Lecturer && lecturerObj.getID() == teacherID){
                                    //flag variable set to true because tutor ids match meaning tutor has already been added
                                    isAdded = true;
                                    //breaking the loop once ids match
                                    break;
                                }
                            }
                            //checking if tutor is added or not
                            if(isAdded == true){
                                //Displaying an error message
                                JOptionPane.showMessageDialog(lecturerFrame, "Lecturer with that ID is already added", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                //adding lecturer to the arraylist
                                Teacher.add(lecturers);
                                //setting graded score 
                                lecturers.setGradedScore(gradedScore);
                                //displaying that the lecturer has been added
                                JOptionPane.showMessageDialog(lecturerFrame, "Lecturer added", "Add Lecturer", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            //adding lecturer to the arraylist because there are no entries in the arraylist 
                            Teacher.add(lecturers);
                            //setting graded score
                            lecturers.setGradedScore(gradedScore);
                            //displaying that the lecturer has been added
                            JOptionPane.showMessageDialog(lecturerFrame, "Lecturer added", "Add Lecturer", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }catch(NumberFormatException exp){
                    //error if format does not match
                    JOptionPane.showMessageDialog(lecturerFrame, "Teacher ID, Years Of Experience and Graded Score must be an Integer", "Exception", JOptionPane.ERROR_MESSAGE);
                }
            }       
        }else if(e.getSource() == removeTutor){
            try{
                //extracting the teacher id from jtextfield
                int teacherID = Integer.parseInt(teacherIdFieldT.getText());

                //flag variable
                boolean tutorRemoved = false;

                //checking if the arraylist is empty or not
                if(Teacher.size() > 0){
                    //iterating through the arraylist
                    for(Teacher tutorObj : Teacher){
                        //checking if the object is an instance of tutor or not and checking the teacher ids
                        if(tutorObj instanceof Tutor && teacherID == tutorObj.getID()){
                            //once the teacher id match 
                            //removing the object of tutor 
                            Teacher.remove(tutorObj);
                            //displaying that the tutor is removed
                            JOptionPane.showMessageDialog(tutorFrame, "Tutor Removed", "Tutor Removed", JOptionPane.INFORMATION_MESSAGE);
                            //setting the flag variable to true
                            tutorRemoved = true;
                            //breaking the loop once tutor is removed
                            break;
                        }
                    }
                    
                    //if tutor ids do not match
                    if(tutorRemoved == false){
                        //displaying the teacher id does not match
                        JOptionPane.showMessageDialog(tutorFrame, "Teacher with that Teacher ID does not exist", "Error Occurred", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    //if arraylist is empty then display an error message
                    JOptionPane.showMessageDialog(tutorFrame, "Tutor has not been added", "Error Occurred", JOptionPane.ERROR_MESSAGE);
                }  
            }catch(NumberFormatException exp){
                //if format doesnt match show error
                JOptionPane.showMessageDialog(tutorFrame, "Teacher ID should be an Integer", "Exception Occurred", JOptionPane.ERROR_MESSAGE);
            }

        }else if(e.getSource() == gradeAssignmentGradeButton){
            //extracting the value of department from jtextfield
            String department = departmentGradeField.getText();
            //checking if the field is empty
            if(department.isEmpty()){
                //displaying error
                JOptionPane.showMessageDialog(gradeAssigmentFrame, "Fields are empty\nFill in all the fields and try again", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    //extracting values from jtextfields of data type int
                    int teacherId = Integer.parseInt(teacherIdGradeField.getText());
                    int gradedScore = Integer.parseInt(gradedScoreGradeField.getText());
                    int yrsOfExperience = Integer.parseInt(yrsOfExperienceGradeField.getText());
                    
                    //flag variable
                    boolean lecturerFound = false;
                    
                    //checking if the arraylist is empty or not
                    if(Teacher.size() > 0){
                        //iterating through the arraylist
                        for(Teacher obj : Teacher){
                            //checking if the object is an instance of lecturer and their ids match
                            if(obj instanceof Lecturer && obj.getID() == teacherId){
                                //flag variable set to true
                                lecturerFound = true;
                                //downcasting the teacher object to lecturer object to access its methods
                                Lecturer lecturerObj = (Lecturer) obj;
                                //checking if these conditions match
                                if (yrsOfExperience < 5 || yrsOfExperience > 80){
                                    JOptionPane.showMessageDialog(tutorFrame, "Years of Experience must be greater than 5 and less than 80", "Error", JOptionPane.ERROR_MESSAGE);
                                }else if(!(lecturerObj.getDepartment().equals(department))){
                                    JOptionPane.showMessageDialog(tutorFrame, "Department of teacher must be same", "Error", JOptionPane.ERROR_MESSAGE);
                                }else if(gradedScore > 100 || gradedScore < 0){
                                    JOptionPane.showMessageDialog(gradeAssigmentFrame, "Graded Score must be greater than 0 and less than 100", "Error", JOptionPane.ERROR_MESSAGE);
                                }else{
                                    String grade;
                                    //checking the graded score and giving grades accordingly
                                    if(gradedScore >= 70){
                                        grade = "Your Grade: A";
                                    }else if(gradedScore >= 60){
                                        grade = "Your Grade: B";
                                    }else if(gradedScore >= 50){
                                        grade = "Your Grade: C";
                                    }else if(gradedScore >= 40){
                                        grade = "Your Grade: D";
                                    }else{
                                        grade = "Your Grade: E";
                                    }
                                    //grading the assignment using the method
                                    lecturerObj.gradeAssignment(gradedScore, department, yrsOfExperience);
                                    //displaying the grade
                                    JOptionPane.showMessageDialog(gradeAssigmentFrame, grade, "Graded", JOptionPane.INFORMATION_MESSAGE);
                                    //breaking the loop once graded.
                                    break;
                                }
                            }
                        }
                        //checking if flag variable is changed or not
                        if(lecturerFound == false){
                            //displaying error 
                            JOptionPane.showMessageDialog(gradeAssigmentFrame, "Lecturer not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        //displaying error
                        JOptionPane.showMessageDialog(gradeAssigmentFrame, "Lecturer has not been added", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(NumberFormatException exp){
                    //displaying error if format does not match
                    JOptionPane.showMessageDialog(gradeAssigmentFrame, "Teacher ID, Graded Score and Years of Experience must be an Integer", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }else if(e.getSource() == setSalaryButton){
            try{
                //extracting the values from jtextfields 
                int teacherId = Integer.parseInt(teacherIdSalaryField.getText());
                double salary = Double.parseDouble(newSalaryField.getText());
                int performanceIndex = Integer.parseInt(performanceIndexSalaryField.getText());
                
                boolean salarySet = false;
                //checking if the arraylist is empty or not
                if(Teacher.size() > 0){
                    //iterating through the arraylist
                    for(Teacher obj : Teacher){
                        //checking if the object is an instance of tutor and checking if the ids match
                        if(obj.getID() == teacherId && obj instanceof Tutor){
                            salarySet = true;
                            //downcasting the teacher object to tutor object to access its methods
                            Tutor tutorObj = (Tutor) obj;
                            //checking if the values are entered correctly
                            if(performanceIndex < 5 || performanceIndex > 10){
                                //displaying error
                                JOptionPane.showMessageDialog(setSalaryFrame, "Performance Index must be greater than 5 and less than 10", "Error", JOptionPane.ERROR_MESSAGE);
                            }else if(tutorObj.getWorkingHour() < 20){
                                //displaying error
                                JOptionPane.showMessageDialog(setSalaryFrame, "Working Hours must be greater than 20", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            else{
                                //setting salary through the method
                                tutorObj.setSalary(salary, performanceIndex);
                                //displaying the new salary and new performance index
                                JOptionPane.showMessageDialog(setSalaryFrame, "New Salary: " + tutorObj.getSalary() + "\n" + "New Performance Index: " + performanceIndexSalaryField.getText());
                                break;
                            }
                        }
                    }
                    if(salarySet == false){
                        //displaying error
                        JOptionPane.showMessageDialog(setSalaryFrame, "Tutor with that ID does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }else{
                    //displaying error
                    JOptionPane.showMessageDialog(setSalaryFrame, "Tutor has not been added", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch(NumberFormatException exp){
                //displaying error if format does not match
                JOptionPane.showMessageDialog(setSalaryFrame, "Teacher ID, Salary and Performance Index must be an Integer", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == clearL){
            //clearing all the textfields
            //confirming with the user if they want to clear or not
            int clear = JOptionPane.showConfirmDialog(lecturerFrame, "Are you sure you want to clear everything", "Clear", JOptionPane.YES_NO_CANCEL_OPTION);
            //if they select yes clear the fields
            if(clear == JOptionPane.YES_OPTION){
                teacherIdFieldL.setText("");
                teacherNameFieldL.setText("");
                addressFieldL.setText("");
                workingTypeFieldL.setText("");
                employmentStatFieldL.setText("");
                gradedScoreField.setText("");
                yrsOfExperienceField.setText("");
                departmentField.setText("");
                workingHoursFieldL.setText("");
            }
            
        }else if(e.getSource() == clearT){
            //clearing all the textfields
            //confirming with the user if they want to clear or not
            int clear = JOptionPane.showConfirmDialog(lecturerFrame, "Are you sure you want to clear everything", "Clear", JOptionPane.YES_NO_CANCEL_OPTION);
            //if they select yes clear the fields
            if(clear == JOptionPane.YES_OPTION){
                teacherIdFieldT.setText("");
                teacherNameFieldT.setText("");
                addressFieldT.setText("");
                workingTypeFieldT.setText("");
                employmentStatFieldT.setText("");
                workingHoursFieldT.setText("");
                salaryField.setText("");
                specializationField.setText("");
                academicQualificationField.setText(""); 
                performanceIndexField.setText("");
            }   
        }else if(e.getSource() == displayT){
            //checking if the arraylist is empty or not
            if(Teacher.size() > 0){
                //checking if the arraylist is empty or not
                for(Teacher  obj : Teacher){
                    //checking if the object is an instance of tutor
                    if(obj instanceof Tutor){
                        //downcasting the teacher object to tutor object to access its methods
                        Tutor tutorObj = (Tutor) obj;
                        //displaying all the details
                        JOptionPane.showMessageDialog(tutorFrame, "ID: " + tutorObj.getID() + "\n" + "Name: " + tutorObj.getName() + "\n" + "Address: " + tutorObj.getAddress() + "\n" + "Working Type: "  + tutorObj.getWorkType() + "\n" + "Employment Status: "  + tutorObj.getEmploymentStat() + "\n" + "Working Hour: " + tutorObj.getWorkingHour()  + "\n" + "Salary: " + tutorObj.getSalary()  + "\n" +  "Specialization: " + tutorObj.getSpecialization() + "\n" + "Academic Qualification: " + tutorObj.getAcademicQualification()  + "\n" + "Performance Index: " + tutorObj.getPerformanceIndex());
                    }
                }
            }else{
                //displaying error is no entries found
                JOptionPane.showMessageDialog(tutorFrame, "No Tutor Added", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == displayL){
            //checking if the arraylist is empty or not
            if(Teacher.size() > 0){
                //checking if the arraylist is empty or not
                for(Teacher obj : Teacher){
                    //checking if the object is an instance of lecturer
                    if(obj instanceof Lecturer){
                        //downcasting the teacher object to lecturer object to access its methods
                        Lecturer lecturerObj = (Lecturer) obj;
                        //displaying all the details
                        JOptionPane.showMessageDialog(lecturerFrame, "ID: " + lecturerObj.getID() + "\n" + "Name: " + lecturerObj.getName() + "\n" + "Address: " + lecturerObj.getAddress() + "\n" + "Working Type: "  + lecturerObj.getWorkType() + "\n" + "Employment Status: "  + lecturerObj.getEmploymentStat() + "\n" + "Working Hour: " + lecturerObj.getWorkingHour()  + "\n" + "Graded Score: " + lecturerObj.getGradedScore()  + "\n" +  "Years of Experience: " + lecturerObj.getYrsOfExperience());
                    }
                }
            }else{
                //displaying an error
                JOptionPane.showMessageDialog(lecturerFrame, "No Lecturer Added", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //creating a main method
    public static void main(String[] args) {
        //creating a new object of TeacherGUI
        new TeacherGUI();
    }
}
