package com.example.latihanucp1

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BiodataFormScreen(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }
    var kelamin by remember { mutableStateOf("") }

    val jk = listOf("laki-laki","perempuan")

    var svnama by remember { mutableStateOf("") }
    var svnotelpon by remember { mutableStateOf("") }
    var svkelamin by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),

    ) {
        ProfileHeader()

        Column(
            modifier = Modifier
                .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Title
            Text("Yuk LENGKAPI DATA DIRIMU  !", fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text("Nama") },
                    placeholder = {
                        Row {
                            Spacer(Modifier.width(8.dp))
                            Text("isi Nama anda")
                        }
                    }
                )

                OutlinedTextField(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = notelpon,
                    onValueChange = { notelpon = it },
                    label = { Text("nomor telpon") },
                    placeholder = { Text("masukkan no telpon anda") }
                )

                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    jk.forEach { item ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = kelamin == item,
                                onClick = { kelamin = item }
                            )
                            Text(text = item)
                        }
                    }
                }
            }

            Button(
                onClick = {
                    svnama = nama
                    svnotelpon = notelpon
                    svkelamin = kelamin
                },
                modifier = Modifier .padding(top = 20.dp)
                    .fillMaxWidth()
            ) { Text(text = "Submit") }

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray),
                horizontalAlignment = Alignment.Start
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    Detail(
                        judul = "No Telpon",
                        isinya = svnotelpon,)


                    Detail(
                        judul = "Jenis Kelamin",
                        isinya = svkelamin)
                }
            }
        }
    }
}

@Composable
fun Detail(judul: String, isinya: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)


    ) {
        Text(
            text = judul,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f),
            color = Color.Black
        )
        Text(
            text = ":",
            modifier = Modifier.weight(0.1f),


            )
        Text(
            text = isinya,
            modifier = Modifier.weight(2f),

            )
    }
}

@Composable
fun ProfileHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E88E5))
            .padding(16.dp)
    ) {


        Spacer(modifier = Modifier.width(8.dp))
        // User greeting
        Column {
            Text(text = "Halo,", color = Color.White, fontSize = 30.sp)
            Text(
                text = "Adwita Fernanda",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(150.dp))
        // Profile image with circular background
        Row (verticalAlignment = Alignment.Bottom){
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ipsec), // Profile image resource
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(100.dp).clip(CircleShape)
                )
            }
            Box(
                modifier = Modifier
                    .offset(x = -26.dp)
                    .offset(y = 7.dp)
            ){
                Icon(modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))

                    ,imageVector = Icons.Filled.CheckCircle,
                    contentDescription = null, tint = Color.Green
                )
            }

        }
        Spacer(modifier = Modifier.weight(1f))
        // Notification icon
        Icon(imageVector = Icons.Filled.Add, contentDescription = null, tint = Color.White)
    }
}