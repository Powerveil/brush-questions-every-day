package com.power._2023.study_2023_4;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

public class TrainTicketSystem extends JFrame {
    private JLabel fromLabel, toLabel, dateLabel;
    private JComboBox<String> fromBox, toBox, dateBox;
    private JButton searchBtn, buyBtn;
    private JTable trainTable;
    private JTextField nameField, idField;
    private JLabel seatLabel, priceLabel, timeLabel;
    private JTextArea infoArea;

    private String[] stations = {"桂林", "南宁", "北海"};
    private String[] dates = {"今天", "明天", "后天"};

    private ArrayList<Train> trains = new ArrayList<>();
    private Train selectedTrain;
    private String selectedDate;

    public TrainTicketSystem() {
        setTitle("火车票购票系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 顶部查询面板
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        fromLabel = new JLabel("起点站:");
        topPanel.add(fromLabel);
        fromBox = new JComboBox<>(stations);
        topPanel.add(fromBox);

        toLabel = new JLabel("终点站:");
        topPanel.add(toLabel);
        toBox = new JComboBox<>(stations);
        topPanel.add(toBox);

        dateLabel = new JLabel("出发日期:");
        topPanel.add(dateLabel);
        dateBox = new JComboBox<>(dates);
        topPanel.add(dateBox);

        searchBtn = new JButton("查询");
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTrains();
            }
        });
        topPanel.add(searchBtn);

        add(topPanel, BorderLayout.NORTH);

        // 中间车次列表面板
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        String[] columns = {"车次编号", "发车时刻", "预计开行时间长度", "票价", "座位数"};
        String[][] data = {};
        trainTable = new JTable(data, columns);
        trainTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = trainTable.getSelectedRow();
                if (selectedRow >= 0) {
                    selectedTrain = trains.get(selectedRow);
                    seatLabel.setText("座位数：" + selectedTrain.getSeatCount());
                    priceLabel.setText("票价：" + selectedTrain.getPrice());
                    timeLabel.setText("预计开行时间长度：" + selectedTrain.getDuration() + "小时");
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(trainTable);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());

        seatLabel = new JLabel("座位数：");
        infoPanel.add(seatLabel);

        priceLabel = new JLabel("票价：");
        infoPanel.add(priceLabel);

        timeLabel = new JLabel("预计开行时间长度：");
        infoPanel.add(timeLabel);

        centerPanel.add(infoPanel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // 底部购票面板
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        JLabel nameLabel = new JLabel("姓名：");
        inputPanel.add(nameLabel);
        nameField = new JTextField();
        inputPanel.add(nameField);

        JLabel idLabel = new JLabel("证件号码：");
        inputPanel.add(idLabel);
        idField = new JTextField();
        inputPanel.add(idField);

        bottomPanel.add(inputPanel, BorderLayout.NORTH);

        buyBtn = new JButton("购票");
        buyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyTicket();
            }
        });
        bottomPanel.add(buyBtn, BorderLayout.CENTER);

        infoArea = new JTextArea();
        bottomPanel.add(infoArea, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void searchTrains() {
        String from = (String) fromBox.getSelectedItem();
        String to = (String) toBox.getSelectedItem();
        int days = dateBox.getSelectedIndex();

        // 模拟数据
        trains.clear();
        trains.add(new Train("A100", "8:00", 130, 2.1, 130, "桂林", "南宁"));
        trains.add(new Train("A101", "12:00", 130, 2.1, 130, "桂林", "南宁"));
        trains.add(new Train("B100", "9:00", 135, 2.1, 135, "南宁", "桂林"));
        trains.add(new Train("B101", "14:20", 135, 2.1, 135, "南宁", "桂林"));
        trains.add(new Train("C100", "11:00", 100, 1.4, 100, "南宁", "北海"));
        trains.add(new Train("C101", "13:30", 95, 1.4, 95, "北海", "南宁"));
        trains.add(new Train("D100", "10:10", 1.5, 95, 20, "南宁", "北海"));
        trains.add(new Train("D101", "11:50", 1.5, 95, 20, "北海", "南宁"));

        // 过滤符合条件的车次
        ArrayList<Train> filteredTrains = new ArrayList<>();
        for (Train train : trains) {
            if (train.getFrom().equals(from) && train.getTo().equals(to)) {
                filteredTrains.add(train);
            }
        }

        // 更新车次列表
        String[][] data = new String[filteredTrains.size()][5];
        for (int i = 0; i < filteredTrains.size(); i++) {
            Train train = filteredTrains.get(i);
            data[i][0] = train.getNumber();
            data[i][1] = train.getDepartureTime();
            data[i][2] = train.getDuration() + "";
            data[i][3] = train.getPrice() + "";
            data[i][4] = train.getSeatCount() + "";
        }
        trainTable.setModel(new DefaultTableModel(data, new String[]{"车次编号", "发车时刻", "预计开行时间长度", "票价", "座位数"}));

        selectedTrain = null;
        seatLabel.setText("座位数：");
        priceLabel.setText("票价：");
        timeLabel.setText("预计开行时间长度：");
    }

    private void buyTicket() {
        if (selectedTrain == null) {
            JOptionPane.showMessageDialog(this, "请先选择车次");
            return;
        }

        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入乘客姓名");
            return;
        }

        String id = idField.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入证件号码");
            return;
        }

        selectedDate = dates[dateBox.getSelectedIndex()];
        int seatNo = selectedTrain.bookSeat();
        if (seatNo == -1) {
            JOptionPane.showMessageDialog(this, "该车次已无余票");
            return;
        }

        String info = "出发日期：" + selectedDate + "\n"
                + "起点站：" + selectedTrain.getFrom() + "\n"
                + "终点站：" + selectedTrain.getTo() + "\n"
                + "车次编号：" + selectedTrain.getNumber() + "\n"
                + "座位编号：" + seatNo + "\n"
                + "发车时刻：" + selectedTrain.getDepartureTime() + "\n"
                + "预计开行时间长度：" + selectedTrain.getDuration() + "小时\n"
                + "乘车人：" + name + "\n"
                + "票价：" + selectedTrain.getPrice() + "元";

        infoArea.setText(info);
    }

    public static void main(String[] args) {
        new TrainTicketSystem();
    }

    private class Train {
        private String number;
        private String departureTime;
        private double duration;
        private double price;
        private int seatCount;
        private String from;
        private String to;

        public Train(String number, String departureTime, double duration, double price, int seatCount, String from, String to) {
            this.number = number;
            this.departureTime = departureTime;
            this.duration = duration;
            this.price = price;
            this.seatCount = seatCount;
            this.from = from;
            this.to = to;
        }

        public String getNumber() {
            return number;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public double getDuration() {
            return duration;
        }

        public double getPrice() {
            return price;
        }

        public int getSeatCount() {
            return seatCount;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public int bookSeat() {
            if (seatCount > 0) {
                seatCount--;
                return seatCount;
            } else {
                return -1;
            }
        }
    }
}
