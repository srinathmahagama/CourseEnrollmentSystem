/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrollmentsys;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Srinath
 */
public class enterRes extends javax.swing.JFrame {

    ArrayList<String> subject=new ArrayList<>();
    
    public enterRes() {
        initComponents();
        cs_1201.setEnabled(false);
        cs_1202.setEnabled(false);
        cs_1203.setEnabled(false);
        cs_1204.setEnabled(false);
        cs_1205.setEnabled(false);
        cs_1206.setEnabled(false);
    }
    
    
    
    public void resultSetToTableModel(ResultSet rs,JTable table) throws SQLException
    {
        //create new tableModel.
        DefaultTableModel tableModel=new DefaultTableModel();
        
        //retrieve meta data from resultset
        ResultSetMetaData metaData = rs.getMetaData();
        
        //get no of column from metadata
        int columnCount =metaData.getColumnCount();
        
        //get all column namesfrom metadata and add column to table model. 
        for (int column=1 ; column<=columnCount;column++){
            tableModel.addColumn(metaData.getColumnLabel(column));
        }
        
        //create array of object withsize of column count from meta data.
        Object[] row=new Object[columnCount];
        
        //scroll through result set
        while (rs.next()){
            //get object from column with specific index of result set to array of objects.
            for (int columnIndex=0 ;columnIndex <columnCount ;columnIndex++){
                row[columnIndex]=rs.getObject(columnIndex+1);
            }
            //add that row to tablemodel as an argument with that array of objects.
            tableModel.addRow(row);
        }
        //add that table model to our table.
        table.setModel(tableModel);
    }
     public void SearchAll(){
        Connection con = getConnection();
        PreparedStatement ps;
        ResultSet res=null;
        try {
            ps = con.prepareStatement("SELECT *  FROM resultsem1");
            res=ps.executeQuery();
            resultSetToTableModel(res,sem1Res);
        } catch (SQLException ex) {
            Logger.getLogger(viewStudent.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
     
    public void setEnableWantedTextFilds(){
        for(int i=0;i<subject.size();++i){
            System.out.println(subject.get(i));
            String num=subject.get(i);
            if(num.equals("1201")){
                cs_1201.setEnabled(true);
            }
            else if(num.equals("1202")){
                cs_1202.setEnabled(true);
            }
            if(num.equals("1203")){
                cs_1203.setEnabled(true);
            }
            else if(num.equals("1204")){
                cs_1204.setEnabled(true);
            }
            if(num.equals("1205")){
                cs_1205.setEnabled(true);
            }
            else if(num.equals("1206")){
                cs_1206.setEnabled(true);
            }
            
        }
    }
     
     public void getIdealDataFromDb(String sem){
        try {
            System.out.println("here in");
            Connection conn=getConnection();
            String nicWant=nic.getText();
            String query=null;
            System.out.println(sem);
            if(sem.equals("Semister_1")){
                System.out.println("in if");
                query="SELECT subject_1,subject_2,subject_3,subject_4 FROM subsemi_1 WHERE nic=?";
            }
            else{
                query="SELECT subject_8,subject_9,subject_10,subject_11 FROM subsemi_2 WHERE nic=?";
            }
            PreparedStatement pre=conn.prepareStatement(query);
            pre.setString(1,nicWant);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                if(sem.equals("Semister_1")){
                    subject.add(rs.getString("subject_1"));
                    subject.add(rs.getString("subject_2"));
                    subject.add(rs.getString("subject_3"));
                    subject.add(rs.getString("subject_4"));
                }
                else{
                    subject.add(rs.getString("subject_8"));
                    subject.add(rs.getString("subject_9"));
                    subject.add(rs.getString("subject_10"));
                    subject.add(rs.getString("subject_11"));
                }
                
                System.out.println("here");
            }
            setEnableWantedTextFilds();
            
        } catch (SQLException ex) {
            Logger.getLogger(enterRes.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void viewAll(){
         Connection con = getConnection();
         ResultSet res=null;
         
        try {
            PreparedStatement ps =con.prepareStatement("SELECT * FROM resultsem1");
            
            res=ps.executeQuery();
            resultSetToTableModel(res,sem1Res);
        } catch (SQLException ex) {
            Logger.getLogger(enterRes.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }
    
    public void Grades(){
        String Nic = nic.getText();
        String stu = studentno.getText();
        
        
        int i=0;
        int mark[]=new int[4];
        int num1;
        int num2;
        int num3;
        int num4;
        int num5;
        int num6;
       
//        if(cs_1201.isEnabled()){
//            num1=Integer.parseInt(cs_1201.getText());
//            mark[i]=num1;
//            ++i;
//        }
//        else if(cs_1202.isEnabled()){
//            num2=Integer.parseInt(cs_1202.getText());
//            mark[i]=num2;
//            ++i;
//        }
//        if(cs_1203.isEnabled()){
//            num3=Integer.parseInt(cs_1203.getText());
//            mark[i]=num3;
//            ++i;
//        }
//        else if(cs_1204.isEnabled()){
//            num4=Integer.parseInt(cs_1204.getText());
//            mark[i]=num4;
//            ++i;
//        }
//        if(cs_1205.isEnabled()){
//            num5=Integer.parseInt(cs_1205.getText());
//            mark[i]=num5;
//            ++i;
//        }
//        else if(cs_1206.isEnabled()){
//            num6=Integer.parseInt(cs_1206.getText());
//            mark[i]=num6;
//            ++i;
//        }
        
//        String s1 = cs_1201.getText();
//        String s2 = cs_1202.getText();
//        String s3 = cs_1203.getText();
//        String s4 = cs_1204.getText();
//        String s5 = cs_1205.getText();
//        String s6 = cs_1206.getText();
//        
//        int num1 = Integer.parseInt(s1);
//        int num2 = Integer.parseInt(s2);
//        int num3 = Integer.parseInt(s3);
//        int num4 = Integer.parseInt(s4);
//        int num5 = Integer.parseInt(s5);
//        int num6 = Integer.parseInt(s6);
        
//        int markArray[]={num1,num2,num3,num4,num5,num6};
//        int i,j;
////        String g;
////        String gArray[]=new String[4];
////        for(i=0;i<4;i++){
////            if(mark[i]>=75){
////                g= "A";
////            }
////            else if(mark[i]<75 && mark[i]>=65){
////                g= "B" ;  
////            }
////            else if(mark[i]<65 && mark[i]>=55){
////                g= "C" ;  
////            }
////            else if(mark[i]<55 && mark[i]>=45){
////                g= "D" ;
////            }   
////            else{
////                g="F"; 
////            }
////            
////            gArray[i]=g;
//            
//        }
        Connection con1 = getConnection();
        
        try {
            PreparedStatement ps=con1.prepareStatement("INSERT INTO resultsem1 VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1,stu);
            ps.setString(2,Nic);
            for(i=0;i<6;i++){
                ps.setString(3+i,"Not Selected");
            }
                if(cs_1201.isEnabled()){
                    num1=Integer.parseInt(cs_1201.getText());
                    String n=getGrade(num1);
                    ps.setString(3,n);
                }
                if(cs_1202.isEnabled()){
                    num2=Integer.parseInt(cs_1202.getText());
                    String n=getGrade(num2);
                    ps.setString(4,n);
                }
                if(cs_1203.isEnabled()){
                    num3=Integer.parseInt(cs_1203.getText());
                    String n=getGrade(num3);
                    ps.setString(5,n);
                }
                if(cs_1204.isEnabled()){
                    num4=Integer.parseInt(cs_1204.getText());
                    String n=getGrade(num4);
                    ps.setString(6,n);
                }
                if(cs_1205.isEnabled()){
                    num5=Integer.parseInt(cs_1205.getText());
                    String n=getGrade(num5);
                    ps.setString(7,n);
                }
                if(cs_1206.isEnabled()){
                    num6=Integer.parseInt(cs_1206.getText());
                    String n=getGrade(num6);
                    ps.setString(8,n);
                }
        
                
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(enterRes.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
}
    
    public String getGrade(int mark){
        String g;
        String gArray[]=new String[4];
            if(mark>=75){
                g= "A";
            }
            else if(mark<75 && mark>=65){
                g= "B" ;  
            }
            else if(mark<65 && mark>=55){
                g= "C" ;  
            }
            else if(mark<55 && mark>=45){
                g= "D" ;
            }   
            else{
                g="F"; 
            }
            
        return g;
   }
    
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/nsbm","root","");
            JOptionPane.showMessageDialog(null,"Searching");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"error");
            return null;
        }
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cs_1201 = new javax.swing.JTextField();
        cs_1202 = new javax.swing.JTextField();
        cs_1203 = new javax.swing.JTextField();
        cs_1204 = new javax.swing.JTextField();
        cs_1205 = new javax.swing.JTextField();
        cs_1206 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        okBtn = new javax.swing.JButton();
        nic = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        studentno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        sem1Res = new javax.swing.JTable();
        viewBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        backBtn.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CS1202:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CS1201:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("CS1204:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("CS1203:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("CS1205:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("CS1206:");

        cs_1201.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        cs_1202.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        cs_1203.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        cs_1204.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        cs_1205.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        cs_1206.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Enter marks only selected four subjects of that student");

        okBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        okBtn.setText("Enter Result>");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        nic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nic:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Student_no:");

        studentno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        studentno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentnoMouseClicked(evt);
            }
        });

        sem1Res.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sem1Res.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIC", "STU_ID", "Sub1_Mark", "Sub2_Mark", "Sub3_Mark", "Sub4_Mark", "Sub5_Mark", "Sub6_Mark"
            }
        ));
        jScrollPane1.setViewportView(sem1Res);

        viewBtn.setBackground(new java.awt.Color(0, 0, 0));
        viewBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        viewBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewBtn.setText("View All>");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cs_1201, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cs_1206, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cs_1202, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cs_1203, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cs_1205, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cs_1204, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(360, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(studentno, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cs_1201, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cs_1202, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cs_1203, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cs_1204, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cs_1206, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okBtn)))
                    .addComponent(cs_1205, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(viewBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        // TODO add your handling code here:
        Grades();
        SearchAll();
    }//GEN-LAST:event_okBtnActionPerformed

    private void studentnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentnoMouseClicked
        getIdealDataFromDb(exmRe.semeter);
    }//GEN-LAST:event_studentnoMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new frame2().show();
        this.setVisible(false);
    }//GEN-LAST:event_backBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        viewAll();
    }//GEN-LAST:event_viewBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(enterRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(enterRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(enterRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(enterRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new enterRes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField cs_1201;
    private javax.swing.JTextField cs_1202;
    private javax.swing.JTextField cs_1203;
    private javax.swing.JTextField cs_1204;
    private javax.swing.JTextField cs_1205;
    private javax.swing.JTextField cs_1206;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nic;
    private javax.swing.JButton okBtn;
    private javax.swing.JTable sem1Res;
    private javax.swing.JTextField studentno;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
