
package loginandsignup.Stocks;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import loginandsignup.Home;

public class RIL extends javax.swing.JFrame {
    
    private static final Timer newsTimer = new Timer();
    private static final List<String> stockSymbols = List.of("Reliance Industries");
    private static final Timer timer = new Timer();
    private static final HashMap<String, StockData> pd_data = new HashMap<>();
    private boolean isFrozen = false;
    private LocalTime frozenTime = LocalTime.of(03, 36); // Change this to the desired frozen time (3:14 in this example)
    private final Duration freezeDuration = Duration.ofMinutes(1); // Change this to the desired freeze duration (30 minutes in this example)
    
    
    private static final List<String> stockNews = new ArrayList<>();
    private int currentNewsIndex = 0;

    public RIL() {
        initComponents();
        setLocationRelativeTo(null);
        
        newsTimer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            updateStockNewsLabel();
        }
    }, 0, 5000);
        

        
        
        Font defaultFont = new Font("Segoe UI", Font.PLAIN, 14);
    UIManager.put("TextArea.font", defaultFont);
    UIManager.put("TextField.font", defaultFont);
    UIManager.put("Button.font", defaultFont);
    UIManager.put("Label.font", defaultFont);

    UIManager.put("TextArea.background", new Color(150, 170, 160));
    UIManager.put("TextArea.foreground", Color.BLACK);

    // Existing code...

    // JPanel formatting
    jPanel1.setBackground(new Color(255, 204, 204));
    jPanel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // JLabel formatting
    jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 16));
    jLabel6.setFont(new Font("Segoe UI", Font.PLAIN, 12));

    // JButton formatting
    jButton1.setFont(new Font("Segoe UI", Font.BOLD, 14));
    jButton2.setFont(new Font("Segoe UI", Font.BOLD, 14));
    jButton3.setFont(new Font("Segoe UI", Font.BOLD, 14));

    // Add color to buttons
    jButton1.setBackground(new Color(51, 153, 102));  // Green color
    jButton1.setForeground(Color.WHITE);
    jButton2.setBackground(new Color(255, 102, 102)); // Red color
    jButton2.setForeground(Color.WHITE);
    jButton3.setBackground(new Color(102, 102, 255)); // Blue color
    jButton3.setForeground(Color.WHITE);

    // Main panel formatting
    jPanel2.setBackground(new Color(164, 218, 164));
    jPanel2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // Labels formatting
    jLabel2.setFont(new Font("Lucida Handwriting", Font.BOLD, 36));
    jLabel7.setFont(new Font("Segoe UI", Font.BOLD, 14));
    jLabel8.setFont(new Font("Segoe UI", Font.BOLD, 14));
    jLabel9.setFont(new Font("Segoe UI", Font.BOLD, 14));
    jLabel10.setFont(new Font("Segoe UI", Font.BOLD, 14));

    // Add color to JTextArea
    Tarea.setBackground(new Color(102, 102, 102));
    Tarea.setForeground(new Color(204, 204, 204));

    // Add border and color to JTextArea scroll pane
    jScrollPane2.setBorder(BorderFactory.createLineBorder(new Color(51, 51, 51), 1));
    jScrollPane2.setBackground(new Color(51, 51, 51));

    // Add hover effect to buttons
    addButtonHoverEffect(jButton1);
    addButtonHoverEffect(jButton2);
    addButtonHoverEffect(jButton3);

    // Adjustments to improve spacing and alignment
    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    

        
        
        
        
        
        
        
        
        

        jPanel2.setBackground(new java.awt.Color(241, 242, 242));


        // Customize the appearance of the JTextArea
        Tarea.setBackground(new java.awt.Color(150,170,160));
        Tarea.setForeground(new java.awt.Color(0, 0, 0));
        Tarea.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));

        // ... (existing code)

        // Schedule the job to run every 1 second
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkAndGetData();
                updateTextArea();
            }
        }, 0, 1000);
    }
    
    
    private void addButtonHoverEffect(JButton button) {
    Color originalColor = button.getBackground();
    
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(originalColor.brighter());
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(originalColor);
        }
    });
}

    
    private void updateStockNewsLabel() {
    String[] news = {
        "Stock market hits new highs!",
        "Investors optimistic about future earnings",
        "Technology stocks lead the market",
        "Federal Reserve announces interest rate decision",
        "Global economic indicators show positive trends",
        "Market trends indicate a bullish sentiment",
        "Invest in the future with innovative companies",
        "Earnings season kicks off with positive reports",
        "Oil prices surge on increased demand",
        "Cryptocurrency market experiences a major rally",
        "Consumer spending boosts retail sector",
        "Biotech stocks gain momentum with new breakthroughs",
        "Trade tensions ease, leading to market optimism",
        "Renewable energy sector sees significant growth",
        "Financial experts predict a strong quarter for stocks",
        "Tech giants unveil new products, driving stock prices up",
        "Global trade agreements positively impact markets",
        "Real estate market shows resilience amid challenges",
        "Investors focus on sustainable and ethical investments",
        "Healthcare sector innovates with new medical advancements"
    };

    int randomIndex = (int) (Math.random() * news.length);
    String randomNews = news[randomIndex];

    jLabel15.setText(randomNews);
}


// Make sure to dispose the newsTimer when your JFrame is closed to prevent memory leaks
public void dispose() {
    super.dispose();
    newsTimer.cancel();
}
    
    
    
    
    
    
//    private void addRandomDecorativeElements() {
//        // Existing code...
//
//        // Add random labels with different fonts and colors
//        String[] randomLabels = {"Profit Zone", "Market Watch", "Financial News", "Invest Now", "Diversify"};
//        Random random = new Random();
//        for (String labelText : randomLabels) {
//            JLabel label = new JLabel(labelText);
//            label.setFont(new Font("Segoe UI", Font.BOLD, random.nextInt(5) + 14));
//            label.setForeground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
//            decorativePanel.add(label);
//        }
//
//        // Add stock news label
//        JLabel stockNewsLabel = new JLabel();
//        stockNewsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//        stockNewsLabel.setForeground(Color.BLACK);
//        decorativePanel.add(stockNewsLabel);
//
//        // Add decorative panel to the main panel
//        jPanel2.add(decorativePanel);
//    }
//
//    private void initializeStockNews() {
//        // Add sample stock news
//        stockNews.add("Market trends show positive growth this quarter.");
//        stockNews.add("Tech stocks surge as new innovations hit the market.");
//        stockNews.add("Investors remain cautious amid global economic uncertainties.");
//        stockNews.add("Cryptocurrency market experiences a significant rally.");
//        stockNews.add("Oil prices stabilize after recent fluctuations.");
//    }
//
//    private void updateStockNews() {
//    String[] news = {
//        "Stock market hits new highs!",
//        "Investors optimistic about future earnings",
//        "Technology stocks lead the market",
//        "Federal Reserve announces interest rate decision",
//        "Global economic indicators show positive trends"
//    };
//
//    int randomIndex = (int) (Math.random() * news.length);
//    String randomNews = news[randomIndex];
//
//    // Assuming jLabel21 is a JLabel
//    jLabel21.setText(randomNews);
//}
//
//
//    int randomIndex = (int) (Math.random() * news.length);
//    String randomNews = news[randomIndex];
//
//    jLabel21.setText(String.valueOf(randomNews));
//
//}


    
    
    
    
    
    
    
 private void checkAndGetData() {
    LocalTime now = LocalTime.now();

    if (isFrozen) {
        // Check if the frozen duration has passed
        LocalTime unfreezeTime = frozenTime.plus(freezeDuration);
        if (now.isAfter(unfreezeTime)) {
            isFrozen = false;
        }
    } else {
        // Check if it's the specified frozen time
        if (now.getHour() == frozenTime.getHour() && now.getMinute() == frozenTime.getMinute()) {
            isFrozen = true;
        }
    }

    // Get data only if it's not frozen
    if (!isFrozen) {
        getData();
    }
}




    private void getData() {
        pd_data.clear();
        
        int max=1681,min=1669;
        
        Random random=new Random();

        for (String ticker : stockSymbols) {
            double open = random.nextInt((max - min) + 1) + min;
            double high = open + Math.random() * 100;
            double low = open - Math.random() * 100;
            double close = low + Math.random() * 200;

            StockData stockData = new StockData(open, high, low, close);
            pd_data.put(ticker, stockData);
        }
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stock Data:\n");
        for (String ticker : pd_data.keySet()) {
            StockData stockData = pd_data.get(ticker);
            sb.append(ticker).append(":\n");
            sb.append("  Open: ").append(stockData.getOpen()).append("\n");
            sb.append("  High: ").append(stockData.getHigh()).append("\n");
            sb.append("  Low: ").append(stockData.getLow()).append("\n");
            sb.append("  Close: ").append(stockData.getClose()).append("\n\n");
        }
        // Append the new data to the existing text
        Tarea.setText(sb.toString());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tarea = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jPanel2.setBackground(new java.awt.Color(164, 218, 164));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel3.setText("Axis Bank");

        jLabel4.setText("Qty  NSE");

        jButton1.setText("BUY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SELL");

        jLabel6.setText("Available Quantity:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jButton1)
                                .addGap(42, 42, 42)
                                .addComponent(jButton2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(41, 41, 41))
        );

        Tarea.setEditable(false);
        Tarea.setBackground(new java.awt.Color(102, 102, 102));
        Tarea.setColumns(20);
        Tarea.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        Tarea.setForeground(new java.awt.Color(204, 204, 204));
        Tarea.setLineWrap(true);
        Tarea.setRows(5);
        Tarea.setWrapStyleWord(true);
        Tarea.setCaretColor(new java.awt.Color(204, 204, 0));
        jScrollPane2.setViewportView(Tarea);

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ril.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 3, 36)); // NOI18N
        jLabel2.setText("Reliance");

        jTextArea1.setBackground(new java.awt.Color(255, 220, 220));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Pristina", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Reliance Industries Limited is a conglomerate based in India with diversified interests across various industries, including petrochemicals, refining, oil and gas exploration, telecommunications, retail, and digital services.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(jTextArea1);

        jLabel7.setText("Parent Org.");

        jLabel8.setText("Founded");

        jLabel9.setText("Managing Director");

        jLabel10.setText("NSE Symbol");

        jLabel11.setText("Reliance Industries");

        jLabel12.setText("1973");

        jLabel13.setText("Shri. Mukesh Ambani");

        jLabel14.setText("RELIANCE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        jLabel15.setBackground(new java.awt.Color(0, 204, 204));
        jLabel15.setText("jLabel15");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 753, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(361, 361, 361)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(457, 457, 457)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addComponent(jLabel15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 64, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
  
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Home a = new Home();
        a.show();
        
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
        RIL axis1 = new RIL();
        // Center the JFrame on the screen
        axis1.setLocationRelativeTo(null);
        axis1.setVisible(true);
    });
}

    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Tarea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
