import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:puja_que_puja/screens/pantalla_inicial_temporal/home.dart';
import 'package:puja_que_puja/shared/resources/textos.dart';
import 'package:puja_que_puja/shared/rutas.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: Textos.nombreApp,
      theme: ThemeData.light(),
      routes: Rutas.rutas,
      debugShowCheckedModeBanner: true,
      home: PantallaTemporal(title: 'Flutter Demo Home Page'),
    );
  }
}
