using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlTypes;
using System.Drawing;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace Primary_School
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }
        string visitor;
         int answer;

        public void setAns(int ans)
        {
            answer = ans;
        }

        public void guestName(string user)  // The 'user' variable is only used inside the method and receives the variable value from Form 1
        {
            visitor = user;  // We make the variable 'visitor' that we declared publicly above, equal to the variable that was passed into the method so we can use it.

            lblHello.Text = ($"{visitor}");  //Finally we display the value to a label
        }

        private void btnLogout_Click(object sender, EventArgs e)
        {
            Form1 form1 = new Form1();
            form1.Show();
            this.Hide();
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void btnGo_Click(object sender, EventArgs e)
        {
            //int n1 = Convert.ToInt32(txtInput.Text);
            //int n1 = int.Parse(txtInput.Text);
            int n1 = 0;
            //var isNumeric = int.TryParse(txtInput.Text, out n1);           

 
            if (!String.IsNullOrWhiteSpace(txtInput.Text))
            {
                if (Int32.TryParse(txtInput.Text, out n1))
                {
                    if (n1 >= 1 && n1 <= 10)
                    {
                        Random rnd = new Random();
                        int rnum = rnd.Next(1, 10);

                        int answer = n1 * rnum;
                        setAns(answer);
 
                        txtOutput.Text = "";
                        txtOutput.AppendText($"{n1} x {rnum} = ?");

                        txtboxHint.Text = String.Empty;
                        for (int i = 0; i < 11; i++)
                        {
                            int multiply = i * n1;
                            txtboxHint.Text += i + " x " + n1 + " = " + multiply + "\r\n";
                        }
                    }
                    else
                    {
                        txtOutput.Text = "";
                        txtboxHint.Text = String.Empty;
                        txtboxHint.AppendText("Let's start with numbers between 1 and 10");
                    }
                }
                else
                {
                    txtOutput.Text = "";
                    MessageBox.Show("Enter a NUMBER");
                }
            }
            else
            {
                MessageBox.Show("Enter something");            }

            /*        if (n1 >= 1 && n1 <= 10)
                    {
                        txtboxHint.Text = String.Empty;
                        for (int i = 0; i < 11; i++)
                        {
                            int multiply = i * n1;
                            txtboxHint.Text += i + " x " + n1 + " = " + multiply + "\r\n";
                        }
                    }
                    else
                    {
                        txtboxHint.Text = String.Empty;
                        txtboxHint.AppendText("Let's start with numbers between 1 and 10");
                    }*/

        }

        static int counter;
        private void btnCheck_Click(object sender, EventArgs e)
        {
            
            int aN = Convert.ToInt32(txtAnswer.Text);
            if (aN == answer)
            {
                counter++;
                trophy trophyBox = new trophy();
                trophyBox.Show();
                lblScore.Text = counter.ToString();
            }

            else
            {
                string message2 = "Try Again";
                MessageBox.Show(message2);
            }
        }

        private void btnHint_Click(object sender, EventArgs e)
        {
            if (txtboxHint.Visible)
            {
                txtboxHint.Hide();
            }
            else
            {
                txtboxHint.Show();
            }
        }
    }
}
