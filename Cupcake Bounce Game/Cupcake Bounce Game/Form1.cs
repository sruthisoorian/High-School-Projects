using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WMPLib;



namespace Cupcake_Bounce_Game
{
    public partial class Form1 : Form
    {
        int speedtop = 4;
        int speedleft = 4;
        int point = 0;
        WMPLib.WindowsMediaPlayer player = new WMPLib.WindowsMediaPlayer();

        public Form1()
        {
            InitializeComponent();
            player.URL = "cutemusicmp3.mp3";
            timer1.Enabled = true;
            Cursor.Hide();
            this.TopMost = true;
            label2.Hide();

            pictureBox2.Top = panel1.Bottom - (panel1.Bottom / 10);
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            player.controls.play();
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Escape)
            {
                this.Close();
            }
            }

        private void timer1_Tick(object sender, EventArgs e)
        {
            pictureBox2.Left = Cursor.Position.X - (pictureBox2.Width / 2);
            pictureBox1.Left += speedleft;
            pictureBox1.Top += speedtop;

            if (pictureBox1.Bottom >= pictureBox2.Top && pictureBox1.Bottom <= pictureBox2.Bottom && pictureBox1.Left >= pictureBox2.Left && pictureBox1.Right <= pictureBox2.Right)
            {
                speedtop += 2;
                speedleft += 2;
                speedtop = -speedtop;
                point += 1;
                label1.Text = ("Pretty Points: " + point);

            }
            if (pictureBox1.Left <= panel1.Left)
            {
                speedleft = -speedleft;
            }
            if (pictureBox1.Right >= panel1.Right)
            {
                speedleft = -speedleft;
            }
            if (pictureBox1.Top <= panel1.Top)
            {
                speedtop = -speedtop;
            }
            if (pictureBox1.Bottom >= panel1.Bottom)
            {
                timer1.Enabled = false;
                label2.Show();
                pictureBox2.Hide();
                pictureBox1.Hide();
                label1.Location = new Point(195, 204);


            }
        }
        }
    }

