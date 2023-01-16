using System;
using System.Windows.Forms;

namespace Primary_School
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        string userName;
        string password;

        private void btnLogin_Click(object sender, EventArgs e)
        {
            userName = txtUsername.Text;
            password = txtPassword.Text;

            if (userName == "Buddy" && password == "123")
            {
                Form2 form2 = new Form2();
                form2.guestName(userName);
                form2.Show();
                this.Hide();
            }
            else
            {
                MessageBox.Show("Incorrect details. Try again 😊");
            }
        }
    }
}
