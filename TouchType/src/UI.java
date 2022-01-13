import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class UI extends JFrame implements KeyListener, ActionListener {
    GridBagConstraints gbc = new GridBagConstraints();

    JMenuBar menuBar = new JMenuBar();

    JMenu file = new JMenu("File");
    JMenu text = new JMenu("Text");
    JMenu textType = new JMenu("Text Type");
    JMenu font = new JMenu("Font");
    //file item
    JMenuItem exit = new JMenuItem("Exit");
    // text type items
    JMenuItem quotes = new JMenuItem("Quotes");
    JMenuItem poems = new JMenuItem("Poems");
    JMenuItem facts = new JMenuItem("Facts");
    //font items
    JMenuItem font20 = new JMenuItem("20");
    JMenuItem font25 = new JMenuItem("25");
    JMenuItem font30 = new JMenuItem("30");

    JLabel title;
    JTextArea textArea = new JTextArea();
    JTextArea stats = new JTextArea("WPM: \nAccuracy:             \nErrors: ");

    ImageIcon touchTypeIcon = new ImageIcon("C:\\Users\\Admin 1\\Development\\TouchType\\src\\Touch Type Logo HQ.jpg");

    JPanel statContainer = new JPanel(); // stats will be added to JPanel, will be displayed once a quote is finished
    JButton newQuoteButton = new JButton("New Text");
    String[] textAreaString = new String[]{"The important thing is not to stop questioning. Curiosity has its own reason for existence. One cannot help but be in awe when he contemplates the mysteries of eternity, of life, of the marvelous structure of reality. It is enough if one tries merely to comprehend a little of this mystery each day.",
            "There may be times when we are powerless to prevent injustice, but there must never be a time when we fail to protest.", "I am enough of an artist to draw freely upon my imagination. Imagination is more important than knowledge. Knowledge is limited. Imagination encircles the world.",
            "Sometimes the questions are complicated and the answers are simple.",
            "One glance at a book and you hear the voice of another person, perhaps someone dead for 1,000 years. To read is to voyage through time.",
            "The atoms of our bodies are traceable to stars that manufactured them in their cores and exploded these enriched ingredients across our galaxy, billions of years ago. For this reason, we are biologically connected to every other living thing in the world. We are chemically connected to all molecules on Earth. And we are atomically connected to all atoms in the universe. We are not figuratively, but literally stardust.",
            "Words have a magical power. They can bring either the greatest happiness or deepest despair; they can transfer knowledge from teacher to student; words enable the orator to sway his audience and dictate its decisions. Words are capable of arousing the strongest emotions and prompting all men's actions.",
            "The only person you are destined to become is the person you decide to be." };
    String[] quoteString = new String[] {"For, after all, how do we know that two and two make four? Or that the force of gravity works? Or that the past is unchangeable? " +
            "If both the past and the external world exist only in the mind, and if the mind itself is controllable - what then?",
            "The voice of the sea is seductive, never ceasing, whispering, clamoring, murmuring, inviting the soul to wander in abysses of solitude.",
            "The most merciful thing in the world, is the inability of the human mind to correlate all its contents. We live on a placid island of ignorance in the midst of black seas of infinity, and it was not meant that we should voyage far.",
            "Who controls the past controls the future. Who controls the present controls the past." ,
            "There is nothing like looking, if you want to find something. You certainly usually find something, if you look, but it is not always quite the something you were after.",
            "The nitrogen in our DNA, the calcium in our teeth, the iron in our blood, the carbon in our apple pies were made in the interiors of collapsing stars. We are made of starstuff.",
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand.",};
    String[] poemString = new String[] {"I dream'd in a dream\n" +
            "I saw a city invincible to the attacks of the\n" +
            "whole of the rest of the earth,\n" +
            "I dream'd that was the new city of Friends,\n" +
            "Nothing was greater there\n" +
            "than the quality of robust love, it led the rest,\n" +
            "It was seen every hour in the actions of the men of that city,\n" +
            "And in all their looks and words.",
            "The rose is a rose,\n" + "And was always a rose.\n" + "But the theory now goes\n" + "That the apple’s a rose,\n" + "And the pear is, and so’s\n" +
                    "The plum, I suppose.\n" + "The dear only knows\n" + "What will next prove a rose.\n" + "You, of course, are a rose -\n" +
                    "But were always a rose.",
            "When despair for the world grows in me\n" +
                    "and I wake in the night at the least sound\n" +
                    "in fear of what my life and my children’s lives may be,\n" +
                    "I go and lie down where the wood drake\n" +
                    "rests in his beauty on the water, and the great heron feeds.\n" +
                    "I come into the peace of wild things\n" +
                    "who do not tax their lives with forethought\n" +
                    "of grief. I come into the presence of still water.\n" +
                    "And I feel above me the day-blind stars\n" +
                    "waiting with their light. For a time\n" +
                    "I rest in the grace of the world, and am free.",
            "The whiskey stink of rot has settled\n" +
                    "in the garden, and a burst of fruit flies rises\n" +
                    "when I touch the dying tomato plants.\n" +
                    "Still, the claws of tiny yellow blossoms\n" +
                    "flail in the air as I pull the vines up by the roots\n" +
                    "and toss them in the compost.\n" +
                    "It feels cruel. Something in me isn’t ready\n" +
                    "to let go of summer so easily. To destroy\n" +
                    "what I’ve carefully cultivated all these months.\n" +
                    "Those pale flowers might still have time to fruit.\n" +
                    "My great-grandmother sang with the girls of her village\n" +
                    "as they pulled the flax. Songs so old\n" +
                    "and so tied to the season that the very sound\n" +
                    "seemed to turn the weather."};
    String [] factString = new String[] {"Bats are the only mammal that can actually fly.",
            "The green code in The Matrix was actually created from symbols in the code designer's wife's sushi cookbook.",
            "The hardest working muscle in your body is your heart: It pumps more than 2,000 gallons of blood a day and beats more than 2.5 billion times in a 70-year life span.",
            "Humans could never \"land\" on Jupiter, Saturn, Uranus or Neptune because they are made of gas and have no solid surface.",
            "The teddy bear is named after President Theodore Roosevelt. After he refused to shoot a captured black bear on a hunt, a stuffed-animal maker decided to create a bear and name it after the president.",
            "Freelancers originally referred to self-employed, sword-wielding mercenaries.",
            "The word \"strengths\" is the longest word in the English language with only one vowel."};
    int stringPosition = 0;
    int keysPressed = 0;
    int mistakes = 0;
    boolean isDone = false;
    double startTime, endTime, totalTime, wpm = 0, accuracy;
    int totalWords;
    Random rand = new Random();
    int randTextString = rand.nextInt(textAreaString.length); // randomized index for text arrays
    // Colors for highlighting
    Color lightBlue = new Color(0,200,255);
    Color orange = new Color(250, 50, 0);
    Highlighter.HighlightPainter bluePainter = new DefaultHighlighter.DefaultHighlightPainter(lightBlue.brighter());
    Highlighter.HighlightPainter redPainter = new DefaultHighlighter.DefaultHighlightPainter(orange.brighter());

    public UI(){
        //window properties
        super("Touch Type");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setResizable(false);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.DARK_GRAY.brighter());
        setJMenuBar(menuBar);

        menuBar.add(file);
        menuBar.add(text);

        file.add(exit);

        text.add(textType);
        textType.add(quotes);
        textType.add(poems);
        textType.add(facts);

        text.add(font);
        font.add(font20);
        font.add(font25);
        font.add(font30);

        textArea.setText(textAreaString[randTextString]);
        textArea.setForeground(Color.BLACK);
        textArea.setFocusable(false);

        title = new JLabel();
        title.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.anchor = GridBagConstraints.PAGE_START;
        Image transformed = touchTypeIcon.getImage().getScaledInstance(480, 205, Image.SCALE_SMOOTH);
        gbc.insets = new Insets(10,10,10,10);
        setConstraints(title, 0, 0, 1, 1);
        title.setIcon(new ImageIcon(transformed));

        setConstraints(newQuoteButton, 0, 2, 1, 1);

        stats.setFocusable(false);
        stats.setFont(new Font("Arial", Font.PLAIN, 18));
        stats.setOpaque(false);
        statContainer.add(stats);
        statContainer.setFocusable(false);
        statContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setConstraints(statContainer, 0, 3, 1, 1);

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 1;
        setConstraints(textArea, 0, 1, 1, 1);

        newQuoteButton.setBackground(new Color(20, 20, 20));
        newQuoteButton.setForeground(Color.white);
        newQuoteButton.addActionListener(this);
        exit.addActionListener(this);
        quotes.addActionListener(this);
        poems.addActionListener(this);
        facts.addActionListener(this);
        font20.addActionListener(this);
        font25.addActionListener(this);
        font30.addActionListener(this);
        newQuoteButton.setFocusable(false);

        addHighlight(textArea, DefaultHighlighter.DefaultPainter, stringPosition, stringPosition + 1); // Initial highlight on first char

        addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {
        if(keysPressed == 1){ // timer starts when first key typed
            startTime = System.currentTimeMillis();
        }
        if(stringPosition  < textAreaString[randTextString].length()){
            char typedChar = e.getKeyChar();
            char currentChar = textAreaString[randTextString].charAt(stringPosition);
            if (typedChar == 8){ // backspace condition removes highlight and updates position
                Highlighter highlight = textArea.getHighlighter();
                Highlighter.Highlight[] highlights = highlight.getHighlights();
                if (stringPosition > 0) {
                    stringPosition--;
                    highlight.removeHighlight(highlights[highlights.length - 2]);
                    removeHighlight(textArea);
                }
                else if(stringPosition == 0){
                    highlight.removeHighlight(highlights[highlights.length - 1]);
                }
            }
            else if (typedChar == currentChar) {
                removeHighlight(textArea);
                addHighlight(textArea, bluePainter, stringPosition, stringPosition + 1);
                stringPosition++;
            }
            else{
                removeHighlight(textArea);
                addHighlight(textArea, redPainter, stringPosition, stringPosition + 1);
                mistakes++;
                stringPosition++;
            }
            addHighlight(textArea, DefaultHighlighter.DefaultPainter, stringPosition , stringPosition + 1);
            if (typedChar != 8){
                keysPressed++;
            }
        }
        if(isDone && e.getKeyChar() == '\n'){
            setNewQuote();
        }
        if(stringPosition == textAreaString[randTextString].length() && wpm == 0){ // print stats only once. if wpm was already calculated, don't update
            isDone = true;
            endTime = System.currentTimeMillis();
            totalTime = (endTime - startTime)/1000;

            totalWords = getTotalWords(textAreaString[randTextString]);
            wpm = getWordsPerMin(totalWords, totalTime);

            double totalChars = textAreaString[randTextString].length();
            accuracy = ((totalChars - mistakes)/totalChars) * 100;

            stats.setText("WPM:      " + String.format("%.2f", wpm) + "\nAccuracy: " +
                    String.format("%.2f", accuracy) + '%' + "\nErrors:      " + mistakes);
        }
    }
    public void setConstraints(JComponent component, int xPos, int yPos, int gridWidth, int gridHeight){
        gbc.gridx = xPos;
        gbc.gridy = yPos;
        gbc.gridwidth = gridWidth;
        gbc.gridheight = gridHeight;
        add(component, gbc);
    }
    public void removeHighlight(JTextComponent textArea){
        Highlighter highlight = textArea.getHighlighter();
        Highlighter.Highlight[] highlights = highlight.getHighlights();
        highlight.removeHighlight(highlights[highlights.length - 1]);
    }
    public void addHighlight(JTextComponent textArea, Highlighter.HighlightPainter painter, int start, int end){
        try{
            textArea.getHighlighter().addHighlight(start, (end), painter);
        } catch (BadLocationException ble){ System.out.println("Error in highlight"); }
    }

    public void setNewQuote(){
        randTextString = rand.nextInt(textAreaString.length);
        textArea.setText(textAreaString[randTextString]);
        stringPosition = 0;
        isDone = false;
        keysPressed = 0;
        mistakes = 0;
        wpm = 0;
        stats.setText("WPM: \nAccuracy:             \nErrors: ");
        Highlighter highlight = textArea.getHighlighter();
        highlight.removeAllHighlights();
        addHighlight(textArea, DefaultHighlighter.DefaultPainter, stringPosition, stringPosition + 1);
    }

    public int getTotalWords(String quote){
        int totalWords = 1;
        for(int i = 0; i < quote.length(); i++){
            if(quote.charAt(i) == ' '){
                totalWords++;
            }
        }
        return totalWords;
    }

    public double getWordsPerMin(int words, double secs){
        return (60.0/secs) * words;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == newQuoteButton){
            setNewQuote();
        }
        // text type menu options
        if(source == quotes){
            textAreaString = quoteString;
            setNewQuote();
            setSize(800,600);
        }
        if(source == poems){
            textAreaString = poemString;
            setNewQuote();
            setSize(800,800);
        }
        if(source == facts){
            textAreaString = factString;
            setNewQuote();
            setSize(800,600);
        }
        // font menu options
        if(source == font20){
            textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        }
        if(source == font25){
            textArea.setFont(new Font("Arial", Font.PLAIN, 25));
        }
        if(source == font30){
            textArea.setFont(new Font("Arial", Font.PLAIN, 30));
        }
        if(source == exit){
            System.exit(0);
        }
    }
}