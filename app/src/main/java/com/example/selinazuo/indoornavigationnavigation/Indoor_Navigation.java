package com.example.selinazuo.indoornavigationnavigation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import com.example.selinazuo.indoornavigationnavigation.Dijksta2;
import com.example.selinazuo.indoornavigationnavigation.Dijksta2.Edge;
import com.example.selinazuo.indoornavigationnavigation.Dijksta2.Vertex;

import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

import java.util.HashMap;
import java.util.List;


public class Indoor_Navigation extends AppCompatActivity {
    private ImageView mImageView;
    private HashMap<String,Integer[]> location = new HashMap();
    private String start;
    private String end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indoor__navigation);
        setUpNodeData();
        Intent intent = getIntent();
        start = intent.getStringExtra("START_POINT");
        end = intent.getStringExtra("END_POINT");
        mImageView = findViewById(R.id.map_image_view);
        Drawable drawable = ContextCompat.getDrawable(Indoor_Navigation.this,R.drawable.map1);
        Bitmap icon = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(icon);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.map1),0,0,null);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15f);
        Path path = new Path();
        String[] reverseArray = dijkstra(start,end);
        Integer[] point = new Integer[]{};
        for(int i=0;i<reverseArray.length;i++){
            if(i==0){
//                path.moveTo(450,700);
                point = location.get(reverseArray[i]);
                path.moveTo(point[0],point[1]);
            }else{
                point = location.get(reverseArray[i]);
                path.lineTo(point[0],point[1]);
            }
        }
        canvas.drawPath(path,paint);
        mImageView.setImageBitmap(icon);
    }

    public String[] dijkstra(String p1,String p2){
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");
        Vertex J = new Vertex("J");
        Vertex K = new Vertex("K");
        Vertex L = new Vertex("L");
        Vertex M = new Vertex("M");
        Vertex N = new Vertex("N");
        Vertex O = new Vertex("O");
        Vertex P = new Vertex("P");
        Vertex Q = new Vertex("Q");
        Vertex R = new Vertex("R");
        Vertex S = new Vertex("S");
        Vertex T = new Vertex("T");
        Vertex U = new Vertex("U");
        Vertex V = new Vertex("V");
        Vertex W = new Vertex("W");
        Vertex X = new Vertex("X");
        Vertex Y = new Vertex("Y");
        Vertex Z1 = new Vertex("Z1");
        Vertex Z2 = new Vertex("Z2");
        Vertex AA = new Vertex("AA");
        Vertex AB = new Vertex("AB");
        Vertex AC = new Vertex("AC");
        Vertex AD = new Vertex("AD");
        Vertex AE = new Vertex("AE");
        Vertex AF = new Vertex("AF");

        List<Edge> eAl = A.adj;
        List<Edge> eBl = B.adj;
        List<Edge> eCl = C.adj;
        List<Edge> eDl = D.adj;
        List<Edge> eEl = E.adj;
        List<Edge> eFl = F.adj;
        List<Edge> eGl = G.adj;
        List<Edge> eHl = H.adj;
        List<Edge> eIl = I.adj;
        List<Edge> eJl = J.adj;
        List<Edge> eKl = K.adj;
        List<Edge> eLl = L.adj;
        List<Edge> eMl = M.adj;
        List<Edge> eNl = N.adj;
        List<Edge> eOl = O.adj;
        List<Edge> ePl = P.adj;
        List<Edge> eQl = Q.adj;
        List<Edge> eRl = R.adj;
        List<Edge> eSl = S.adj;
        List<Edge> eTl = T.adj;
        List<Edge> eUl = U.adj;
        List<Edge> eVl = V.adj;
        List<Edge> eWl = W.adj;
        List<Edge> eXl = X.adj;
        List<Edge> eYl = Y.adj;
        List<Edge> eZ1l = Z1.adj;
        List<Edge> eZ2l = Z2.adj;
        List<Edge> eAAl = AA.adj;
        List<Edge> eABl = AB.adj;
        List<Edge> eACl = AC.adj;
        List<Edge> eADl = AD.adj;
        List<Edge> eAEl = AE.adj;
        List<Edge> eAFl = AF.adj;


        Edge e1 = new Edge(B,1);
        eAl.add(e1);

        Edge e2 = new Edge(A,1);
        Edge e3 = new Edge(C,3);
        Edge e4 = new Edge(E,4);
        Edge e5 = new Edge(AE,2);
        eBl.add(e2);
        eBl.add(e3);
        eBl.add(e4);
        eBl.add(e5);

        Edge e6 = new Edge(B,1);
        eCl.add(e6);

        Edge e7 = new Edge(AE,1);
        eDl.add(e7);

        Edge e8 = new Edge(B,1);
        eEl.add(e8);
        Edge e9 = new Edge(AE,2);
        eEl.add(e9);
        Edge e10 = new Edge(AD,3);
        eEl.add(e10);

        Edge e11 = new Edge(AB,2);
        eFl.add(e11);
        Edge e12 = new Edge(AD,1);
        eFl.add(e12);

        Edge e13 = new Edge(AD,1);
        ePl.add(e13);

        Edge e14 = new Edge(AC,1);
        eQl.add(e14);

        Edge e15 = new Edge(S,2);
        eRl.add(e15);
//        Edge e16 = new Edge(W,1);
//        eRl.add(e16);
        Edge e17 = new Edge(AC,1);
        eRl.add(e17);

        Edge e18 = new Edge(X,1);
        eSl.add(e18);

        Edge e19 = new Edge(U,1);
        eTl.add(e19);
        Edge e20 = new Edge(AF,2);
        eTl.add(e20);

        Edge e21 = new Edge(T,2);
        eUl.add(e21);
        Edge e22 = new Edge(Y,3);
        eUl.add(e22);
        Edge e23 = new Edge(AF,1);
        eUl.add(e23);

        Edge e24 = new Edge(W,1);
        eVl.add(e24);
        Edge e25 = new Edge(Y,2);
        eVl.add(e25);

        Edge e26 = new Edge(V,1);
        eWl.add(e26);

        Edge e27 = new Edge(S,1);
        eXl.add(e27);

        Edge e28 = new Edge(V,2);
        eYl.add(e28);
        Edge e29 = new Edge(U,3);
        eYl.add(e29);
        Edge e30 = new Edge(AB,1);
        eYl.add(e30);

        Edge e31 = new Edge(AA,1);
        eZ1l.add(e31);

        Edge e32 = new Edge(AA,1);
        eZ2l.add(e32);

        Edge e33 = new Edge(Z1,1);
        eAAl.add(e33);
        Edge e34 = new Edge(Z2,3);
        eAAl.add(e34);
        Edge e35 = new Edge(AF,2);
        eAAl.add(e35);

        Edge e36 = new Edge(F,2);
        eABl.add(e36);
        Edge e37 = new Edge(Y,1);
        eABl.add(e37);
        Edge e38 = new Edge(AC,1);
        eABl.add(e38);

        Edge e39 = new Edge(Q,2);
        eACl.add(e39);
        Edge e40 = new Edge(R,1);
        eACl.add(e40);
        Edge e41 = new Edge(AB,3);
        eACl.add(e41);
        Edge e52 = new Edge(S,4);
        eACl.add(e52);

        Edge e42 = new Edge(E,3);
        eADl.add(e42);
        Edge e43 = new Edge(F,2);
        eADl.add(e43);
        Edge e44 = new Edge(P,1);
        eADl.add(e44);

        Edge e45 = new Edge(B,3);
        eAEl.add(e45);
        Edge e46 = new Edge(C,1);
        eAEl.add(e46);
        Edge e47 = new Edge(D,2);
        eAEl.add(e47);
        Edge e48 = new Edge(E,4);
        eAEl.add(e48);

        Edge e49 = new Edge(T,2);
        eAFl.add(e49);
        Edge e50 = new Edge(U,1);
        eAFl.add(e50);
        Edge e51 = new Edge(AA,3);
        eAFl.add(e51);

        Dijksta2.vertexMap.put("A",A);
        Dijksta2.vertexMap.put("B",B);
        Dijksta2.vertexMap.put("C",C);
        Dijksta2.vertexMap.put("D",D);
        Dijksta2.vertexMap.put("E",E);
        Dijksta2.vertexMap.put("F",F);
        Dijksta2.vertexMap.put("G",G);
        Dijksta2.vertexMap.put("H",H);
        Dijksta2.vertexMap.put("I",I);
        Dijksta2.vertexMap.put("J",J);
        Dijksta2.vertexMap.put("K",K);
        Dijksta2.vertexMap.put("L",L);
        Dijksta2.vertexMap.put("M",M);
        Dijksta2.vertexMap.put("N",N);
        Dijksta2.vertexMap.put("O",O);
        Dijksta2.vertexMap.put("P",P);
        Dijksta2.vertexMap.put("Q",Q);
        Dijksta2.vertexMap.put("R",R);
        Dijksta2.vertexMap.put("S",S);
        Dijksta2.vertexMap.put("T",T);
        Dijksta2.vertexMap.put("U",U);
        Dijksta2.vertexMap.put("V",V);
        Dijksta2.vertexMap.put("W",W);
        Dijksta2.vertexMap.put("X",X);
        Dijksta2.vertexMap.put("Y",Y);
        Dijksta2.vertexMap.put("Z1",Z1);
        Dijksta2.vertexMap.put("Z2",Z2);
        Dijksta2.vertexMap.put("AA",AA);
        Dijksta2.vertexMap.put("AB",AB);
        Dijksta2.vertexMap.put("AC",AC);
        Dijksta2.vertexMap.put("AD",AD);
        Dijksta2.vertexMap.put("AE",AE);
        Dijksta2.vertexMap.put("AF",AF);

        return Dijksta2.dijkstra(p1,p2);
    }

    public void setUpNodeData(){
        location.put("A",new Integer[]{450,700});
        location.put("B",new Integer[]{460,800});
        location.put("C",new Integer[]{550,950});
        location.put("D",new Integer[]{700,1100});
        location.put("E",new Integer[]{735,780});
        location.put("F",new Integer[]{1230,800});
        location.put("G",new Integer[]{1000,680});
        location.put("H",new Integer[]{905,560});
        location.put("I",new Integer[]{980,535});
        location.put("J",new Integer[]{1100,535});
        location.put("K",new Integer[]{1200,535});
        location.put("L",new Integer[]{1310,535});
        location.put("M",new Integer[]{1400,535});
        location.put("N",new Integer[]{1405,585});
        location.put("O",new Integer[]{1405,715});
        location.put("P",new Integer[]{1050,1000});
        location.put("Q",new Integer[]{1350,1000});
        location.put("R",new Integer[]{1500,1050});
        location.put("S",new Integer[]{1700,1050});
        location.put("T",new Integer[]{2050,1000});
        location.put("U",new Integer[]{1800,800});
        location.put("V",new Integer[]{1650,500});
        location.put("W",new Integer[]{1650,480});
        location.put("X",new Integer[]{1780,990});
        location.put("Y",new Integer[]{1650,800});
        location.put("Z1",new Integer[]{2800,480});
        location.put("Z2",new Integer[]{2830,1120});
        location.put("AA",new Integer[]{2450,590});
        location.put("AB",new Integer[]{1500,810});
        location.put("AC",new Integer[]{1500,1000});
        location.put("AD",new Integer[]{1050,810});
        location.put("AE",new Integer[]{560,935});
        location.put("AF",new Integer[]{2050,800});
    }
}
