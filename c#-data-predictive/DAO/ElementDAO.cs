﻿using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace santepredect.DAO
{
    class ElementDAO
    {
        public static SqlDataReader FindAll()
        {
            try
            {
                SqlConnection conn = Connexion.Connex();
                conn.Open();
                SqlCommand cmd = new SqlCommand("SELECT * FROM element", conn);
                SqlDataReader reader = cmd.ExecuteReader();

                return reader;
            }
            catch (SqlException ex)
            {
                Console.WriteLine("erreur: " + ex.StackTrace);
                return null;
                //Log exception
                //Display Error message
            }
        }
        public static SqlDataReader FindMaxid()
        {
            try
            {
                SqlConnection conn = Connexion.Connex();

                conn.Open();
                SqlCommand cmd = new SqlCommand("SELECT MAX(id_element) as max FROM element", conn);
                SqlDataReader reader = cmd.ExecuteReader();
                return reader;
            }
            catch (SqlException ex)
            {
                Console.WriteLine("erreur: " + ex.StackTrace);
                return null;
                //Log exception
                //Display Error message
            }
        }
        public static int Insert()
        {
            try
            {
                SqlConnection conn = Connexion.Connex();
                conn.Open();
                SqlCommand cmd = new SqlCommand("INSERT INTO element VALUES(" + "@id_element, @element)", conn);
                SqlDataReader readermax = MaladieDAO.FindMaxid();
                int id = 0;
                if (readermax.HasRows)
                {
                    readermax.Read();

                    id = (int)readermax["max"];

                }
                id++;
                cmd.Parameters.AddWithValue("@id_element", id);
                cmd.Parameters.AddWithValue("@element", "elenent");

                int rows = cmd.ExecuteNonQuery();

                //rows number of record got inserted
                conn.Close();
                return 1;

            }
            catch (SqlException ex)
            {
                Console.WriteLine("erreur: " + ex.StackTrace);
                return 0;
                //Log exception
                //Display Error message
            }
        }
        public static int Update()
        {
            try
            {
                SqlConnection conn = Connexion.Connex();
                conn.Open();

                SqlCommand cmd = new SqlCommand("UPDATE element SET element=@element" + " WHERE id_element=@id_element", conn);

                cmd.Parameters.AddWithValue("@id_element", 10);
                cmd.Parameters.AddWithValue("@element", "Munna Hussain");

                int rows = cmd.ExecuteNonQuery();

                //rows number of record got updated

                conn.Close();
                return 1;
            }
            catch (SqlException ex)
            {
                Console.WriteLine("erreur: " + ex.StackTrace);
                return 0;
                //Log exception
                //Display Error message
            }
        }
        public static int Delete(int Id_maladie)
        {
            try
            {
                SqlConnection conn = Connexion.Connex();
                conn.Open();
                SqlCommand cmd = new SqlCommand("DELETE FROM element " + "WHERE id_element=@id_element", conn);

                cmd.Parameters.AddWithValue("@id_element", Id_maladie);

                int rows = cmd.ExecuteNonQuery();
                conn.Close();
                //rows number of record got deleted
                return 1;

            }
            catch (SqlException ex)
            {
                Console.WriteLine("erreur: " + ex.StackTrace);
                return 0;
                //Log exception
                //Display Error message
            }
        }
    }
}
