package com.example.megatictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import at.markushi.ui.CircleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int layout[][] = {{0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0,0}};
    private int chance=81, score1=0, score2=0;
    private Button b[] = new Button[81];
    private CircleButton undo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListeners();

    }

    @Override
    public void onClick(View v){
        updateLayout(v.getId());
        chance--;
        result(v.getId());
    }

    private void result(int id){
        int result=check(id);
        if(result == 1) pass(true);
        else if(result == 2) pass(false);
    }

    public void pass(boolean b){
        String str="";
        if(b) str="Player One Wins!";
        else str="Player Two Wins!";
        final AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations!").setMessage(str)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(MainActivity.this,MainActivity.class));
                        finish();
                    }
                });
        final AlertDialog dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void tie(){
        final AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(MainActivity.this).setTitle("Ahhhh!").setMessage("It's a tie!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(MainActivity.this,MainActivity.class));
                        finish();
                    }
                });
        final AlertDialog dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.show();
    }

    private int getCurrentBlock(int id){
        switch(id){
            case R.id.b100: case R.id.b101: case R.id.b102: case R.id.b110: case R.id.b111: case R.id.b112: case R.id.b120: case R.id.b121: case R.id.b122:
                return 0;
            case R.id.b200: case R.id.b201: case R.id.b202: case R.id.b210: case R.id.b211: case R.id.b212: case R.id.b220: case R.id.b221: case R.id.b222:
                return 1;
            case R.id.b300: case R.id.b301: case R.id.b302: case R.id.b310: case R.id.b311: case R.id.b312: case R.id.b320: case R.id.b321: case R.id.b322:
                return 2;
            case R.id.b400: case R.id.b401: case R.id.b402: case R.id.b410: case R.id.b411: case R.id.b412: case R.id.b420: case R.id.b421: case R.id.b422:
                return 3;
            case R.id.b500: case R.id.b501: case R.id.b502: case R.id.b510: case R.id.b511: case R.id.b512: case R.id.b520: case R.id.b521: case R.id.b522:
                return 4;
            case R.id.b600: case R.id.b601: case R.id.b602: case R.id.b610: case R.id.b611: case R.id.b612: case R.id.b620: case R.id.b621: case R.id.b622:
                return 5;
            case R.id.b700: case R.id.b701: case R.id.b702: case R.id.b710: case R.id.b711: case R.id.b712: case R.id.b720: case R.id.b721: case R.id.b722:
                return 6;
            case R.id.b800: case R.id.b801: case R.id.b802: case R.id.b810: case R.id.b811: case R.id.b812: case R.id.b820: case R.id.b821: case R.id.b822:
                return 7;
            case R.id.b900: case R.id.b901: case R.id.b902: case R.id.b910: case R.id.b911: case R.id.b912: case R.id.b920: case R.id.b921: case R.id.b922:
                return 8;
        }
        return -1;
    }

    private int check(int id){
        int flag = -1;
        int block = getCurrentBlock(id);
        if(layout[block][0]==1 && layout[block][1]==1 && layout[block][2]==1)
            score1++;
        else if(layout[block][0]==1 && layout[block][3]==1 && layout[block][6]==1)
            score1++;
        else if(layout[block][5]==1 && layout[block][4]==1 && layout[block][3]==1)
            score1++;
        else if(layout[block][1]==1 && layout[block][4]==1 && layout[block][7]==1)
            score1++;
        else if(layout[block][8]==1 && layout[block][7]==1 && layout[block][6]==1)
            score1++;
        else if(layout[block][2]==1 && layout[block][5]==1 && layout[block][8]==1)
            score1++;
        else if(layout[block][8]==1 && layout[block][4]==1 && layout[block][0]==1)
            score1++;
        else if(layout[block][2]==1 && layout[block][4]==1 && layout[block][6]==1)
            score1++;


        else if(layout[block][0]==2 && layout[block][1]==2 && layout[block][2]==2)
            score2++;
        else if(layout[block][0]==2 && layout[block][3]==2 && layout[block][6]==2)
            score2++;
        else if(layout[block][5]==2 && layout[block][4]==2 && layout[block][3]==2)
            score2++;
        else if(layout[block][1]==2 && layout[block][4]==2 && layout[block][7]==2)
            score2++;
        else if(layout[block][8]==2 && layout[block][7]==2 && layout[block][6]==2)
            score2++;
        else if(layout[block][2]==2 && layout[block][5]==2 && layout[block][8]==2)
            score2++;
        else if(layout[block][8]==2 && layout[block][4]==2 && layout[block][0]==2)
            score2++;
        else if(layout[block][2]==2 && layout[block][4]==2 && layout[block][6]==2)
            score2++;

        if(chance == 0){
            if(score1 == score2){
                tie();
                return flag;
            }
            flag = (score1>score2)?1:2;
        }
        return flag;
    }

    private void updateLayout(int id){
        boolean flag=false;
        if(chance%2==1)
            flag=true;
        switch(id){
            // first
            case R.id.b100:{
                if(flag) {
                    b[0].setText("O");
                    layout[0][0]++;
                }
                else {
                    b[0].setText("X");
                    layout[0][0]+=2;
                }
                b[0].setClickable(false);
                break;
            }
            case R.id.b101:{
                if(flag) {
                    b[1].setText("O");
                    layout[0][1]++;
                }
                else {
                    b[1].setText("X");
                    layout[0][1]+=2;
                }
                b[1].setClickable(false);
                break;
            }
            case R.id.b102:{
                if(flag) {
                    b[2].setText("O");
                    layout[0][2]++;
                }
                else {
                    b[2].setText("X");
                    layout[0][2]+=2;
                }
                b[2].setClickable(false);
                break;
            }
            case R.id.b110:{
                if(flag) {
                    b[3].setText("O");
                    layout[0][3]++;
                }
                else {
                    b[3].setText("X");
                    layout[0][3]+=2;
                }
                b[3].setClickable(false);
                break;
            }
            case R.id.b111:{
                if(flag) {
                    b[4].setText("O");
                    layout[0][4]++;
                }
                else {
                    b[4].setText("X");
                    layout[0][4]+=2;
                }
                b[4].setClickable(false);
                break;
            }
            case R.id.b112:{
                if(flag) {
                    b[5].setText("O");
                    layout[0][5]++;
                }
                else {
                    b[5].setText("X");
                    layout[0][5]+=2;
                }
                b[5].setClickable(false);
                break;
            }
            case R.id.b120:{
                if(flag) {
                    b[6].setText("O");
                    layout[0][6]++;
                }
                else {
                    b[6].setText("X");
                    layout[0][6]+=2;
                }
                b[6].setClickable(false);
                break;
            }
            case R.id.b121:{
                if(flag) {
                    b[7].setText("O");
                    layout[0][7]++;
                }
                else {
                    b[7].setText("X");
                    layout[0][7]+=2;
                }
                b[7].setClickable(false);
                break;
            }
            case R.id.b122:{
                if(flag) {
                    b[8].setText("O");
                    layout[0][8]++;
                }
                else {
                    b[8].setText("X");
                    layout[0][8]+=2;
                }
                b[8].setClickable(false);
                break;
            }
            // second
            case R.id.b200:{
                if(flag) {
                    b[9].setText("O");
                    layout[1][0]++;
                }
                else {
                    b[9].setText("X");
                    layout[1][0]+=2;
                }
                b[9].setClickable(false);
                break;
            }
            case R.id.b201:{
                if(flag) {
                    b[10].setText("O");
                    layout[1][1]++;
                }
                else {
                    b[10].setText("X");
                    layout[1][1]+=2;
                }
                b[10].setClickable(false);
                break;
            }
            case R.id.b202:{
                if(flag) {
                    b[11].setText("O");
                    layout[1][2]++;
                }
                else {
                    b[11].setText("X");
                    layout[1][2]+=2;
                }
                b[11].setClickable(false);
                break;
            }
            case R.id.b210:{
                if(flag) {
                    b[12].setText("O");
                    layout[1][3]++;
                }
                else {
                    b[12].setText("X");
                    layout[1][3]+=2;
                }
                b[12].setClickable(false);
                break;
            }
            case R.id.b211:{
                if(flag) {
                    b[13].setText("O");
                    layout[1][4]++;
                }
                else {
                    b[13].setText("X");
                    layout[1][4]+=2;
                }
                b[13].setClickable(false);
                break;
            }
            case R.id.b212:{
                if(flag) {
                    b[14].setText("O");
                    layout[1][5]++;
                }
                else {
                    b[14].setText("X");
                    layout[1][5]+=2;
                }
                b[14].setClickable(false);
                break;
            }
            case R.id.b220:{
                if(flag) {
                    b[15].setText("O");
                    layout[1][6]++;
                }
                else {
                    b[15].setText("X");
                    layout[1][6]+=2;
                }
                b[15].setClickable(false);
                break;
            }
            case R.id.b221:{
                if(flag) {
                    b[16].setText("O");
                    layout[1][7]++;
                }
                else {
                    b[16].setText("X");
                    layout[1][7]+=2;
                }
                b[16].setClickable(false);
                break;
            }
            case R.id.b222:{
                if(flag) {
                    b[17].setText("O");
                    layout[1][8]++;
                }
                else {
                    b[17].setText("X");
                    layout[1][8]+=2;
                }
                b[17].setClickable(false);
                break;
            }
            // third
            case R.id.b300:{
                if(flag) {
                    b[18].setText("O");
                    layout[2][0]++;
                }
                else {
                    b[18].setText("X");
                    layout[2][0]+=2;
                }
                b[18].setClickable(false);
                break;
            }
            case R.id.b301:{
                if(flag) {
                    b[19].setText("O");
                    layout[2][1]++;
                }
                else {
                    b[19].setText("X");
                    layout[2][1]+=2;
                }
                b[19].setClickable(false);
                break;
            }
            case R.id.b302:{
                if(flag) {
                    b[20].setText("O");
                    layout[2][2]++;
                }
                else {
                    b[20].setText("X");
                    layout[2][2]+=2;
                }
                b[20].setClickable(false);
                break;
            }
            case R.id.b310:{
                if(flag) {
                    b[21].setText("O");
                    layout[2][3]++;
                }
                else {
                    b[21].setText("X");
                    layout[2][3]+=2;
                }
                b[21].setClickable(false);
                break;
            }
            case R.id.b311:{
                if(flag) {
                    b[22].setText("O");
                    layout[2][4]++;
                }
                else {
                    b[22].setText("X");
                    layout[2][4]+=2;
                }
                b[22].setClickable(false);
                break;
            }
            case R.id.b312:{
                if(flag) {
                    b[23].setText("O");
                    layout[2][5]++;
                }
                else {
                    b[23].setText("X");
                    layout[2][5]+=2;
                }
                b[23].setClickable(false);
                break;
            }
            case R.id.b320:{
                if(flag) {
                    b[24].setText("O");
                    layout[2][6]++;
                }
                else {
                    b[24].setText("X");
                    layout[2][6]+=2;
                }
                b[24].setClickable(false);
                break;
            }
            case R.id.b321:{
                if(flag) {
                    b[25].setText("O");
                    layout[2][7]++;
                }
                else {
                    b[25].setText("X");
                    layout[2][7]+=2;
                }
                b[25].setClickable(false);
                break;
            }
            case R.id.b322:{
                if(flag) {
                    b[26].setText("O");
                    layout[2][8]++;
                }
                else {
                    b[26].setText("X");
                    layout[2][8]+=2;
                }
                b[26].setClickable(false);
                break;
            }
            // fourth
            case R.id.b400:{
                if(flag) {
                    b[27].setText("O");
                    layout[3][0]++;
                }
                else {
                    b[27].setText("X");
                    layout[3][0]+=2;
                }
                b[27].setClickable(false);
                break;
            }
            case R.id.b401:{
                if(flag) {
                    b[28].setText("O");
                    layout[3][1]++;
                }
                else {
                    b[28].setText("X");
                    layout[3][1]+=2;
                }
                b[28].setClickable(false);
                break;
            }
            case R.id.b402:{
                if(flag) {
                    b[29].setText("O");
                    layout[3][2]++;
                }
                else {
                    b[29].setText("X");
                    layout[3][2]+=2;
                }
                b[29].setClickable(false);
                break;
            }
            case R.id.b410:{
                if(flag) {
                    b[30].setText("O");
                    layout[3][3]++;
                }
                else {
                    b[30].setText("X");
                    layout[3][3]+=2;
                }
                b[30].setClickable(false);
                break;
            }
            case R.id.b411:{
                if(flag) {
                    b[31].setText("O");
                    layout[3][4]++;
                }
                else {
                    b[31].setText("X");
                    layout[3][4]+=2;
                }
                b[31].setClickable(false);
                break;
            }
            case R.id.b412:{
                if(flag) {
                    b[32].setText("O");
                    layout[3][5]++;
                }
                else {
                    b[32].setText("X");
                    layout[3][5]+=2;
                }
                b[32].setClickable(false);
                break;
            }
            case R.id.b420:{
                if(flag) {
                    b[33].setText("O");
                    layout[3][6]++;
                }
                else {
                    b[33].setText("X");
                    layout[3][6]+=2;
                }
                b[33].setClickable(false);
                break;
            }
            case R.id.b421:{
                if(flag) {
                    b[34].setText("O");
                    layout[3][7]++;
                }
                else {
                    b[34].setText("X");
                    layout[3][7]+=2;
                }
                b[34].setClickable(false);
                break;
            }
            case R.id.b422:{
                if(flag) {
                    b[35].setText("O");
                    layout[3][8]++;
                }
                else {
                    b[35].setText("X");
                    layout[3][8]+=2;
                }
                b[35].setClickable(false);
                break;
            }
            // fifth
            case R.id.b500:{
                if(flag) {
                    b[36].setText("O");
                    layout[4][0]++;
                }
                else {
                    b[36].setText("X");
                    layout[4][0]+=2;
                }
                b[36].setClickable(false);
                break;
            }
            case R.id.b501:{
                if(flag) {
                    b[37].setText("O");
                    layout[4][1]++;
                }
                else {
                    b[37].setText("X");
                    layout[4][1]+=2;
                }
                b[37].setClickable(false);
                break;
            }
            case R.id.b502:{
                if(flag) {
                    b[38].setText("O");
                    layout[4][2]++;
                }
                else {
                    b[38].setText("X");
                    layout[4][2]+=2;
                }
                b[38].setClickable(false);
                break;
            }
            case R.id.b510:{
                if(flag) {
                    b[39].setText("O");
                    layout[4][3]++;
                }
                else {
                    b[39].setText("X");
                    layout[4][3]+=2;
                }
                b[39].setClickable(false);
                break;
            }
            case R.id.b511:{
                if(flag) {
                    b[40].setText("O");
                    layout[4][4]++;
                }
                else {
                    b[40].setText("X");
                    layout[4][4]+=2;
                }
                b[40].setClickable(false);
                break;
            }
            case R.id.b512:{
                if(flag) {
                    b[41].setText("O");
                    layout[4][5]++;
                }
                else {
                    b[41].setText("X");
                    layout[4][5]+=2;
                }
                b[41].setClickable(false);
                break;
            }
            case R.id.b520:{
                if(flag) {
                    b[42].setText("O");
                    layout[4][6]++;
                }
                else {
                    b[42].setText("X");
                    layout[4][6]+=2;
                }
                b[42].setClickable(false);
                break;
            }
            case R.id.b521:{
                if(flag) {
                    b[43].setText("O");
                    layout[4][7]++;
                }
                else {
                    b[43].setText("X");
                    layout[4][7]+=2;
                }
                b[43].setClickable(false);
                break;
            }
            case R.id.b522:{
                if(flag) {
                    b[44].setText("O");
                    layout[4][8]++;
                }
                else {
                    b[44].setText("X");
                    layout[4][8]+=2;
                }
                b[44].setClickable(false);
                break;
            }
            // sixth
            case R.id.b600:{
                if(flag) {
                    b[45].setText("O");
                    layout[5][0]++;
                }
                else {
                    b[45].setText("X");
                    layout[5][0]+=2;
                }
                b[45].setClickable(false);
                break;
            }
            case R.id.b601:{
                if(flag) {
                    b[46].setText("O");
                    layout[5][1]++;
                }
                else {
                    b[46].setText("X");
                    layout[5][1]+=2;
                }
                b[46].setClickable(false);
                break;
            }
            case R.id.b602:{
                if(flag) {
                    b[47].setText("O");
                    layout[5][2]++;
                }
                else {
                    b[47].setText("X");
                    layout[5][2]+=2;
                }
                b[47].setClickable(false);
                break;
            }
            case R.id.b610:{
                if(flag) {
                    b[48].setText("O");
                    layout[5][3]++;
                }
                else {
                    b[48].setText("X");
                    layout[5][3]+=2;
                }
                b[48].setClickable(false);
                break;
            }
            case R.id.b611:{
                if(flag) {
                    b[49].setText("O");
                    layout[5][4]++;
                }
                else {
                    b[49].setText("X");
                    layout[5][4]+=2;
                }
                b[49].setClickable(false);
                break;
            }
            case R.id.b612:{
                if(flag) {
                    b[50].setText("O");
                    layout[5][5]++;
                }
                else {
                    b[50].setText("X");
                    layout[5][5]+=2;
                }
                b[50].setClickable(false);
                break;
            }
            case R.id.b620:{
                if(flag) {
                    b[51].setText("O");
                    layout[5][6]++;
                }
                else {
                    b[51].setText("X");
                    layout[5][6]+=2;
                }
                b[51].setClickable(false);
                break;
            }
            case R.id.b621:{
                if(flag) {
                    b[52].setText("O");
                    layout[5][7]++;
                }
                else {
                    b[52].setText("X");
                    layout[5][7]+=2;
                }
                b[52].setClickable(false);
                break;
            }
            case R.id.b622:{
                if(flag) {
                    b[53].setText("O");
                    layout[5][8]++;
                }
                else {
                    b[53].setText("X");
                    layout[5][8]+=2;
                }
                b[53].setClickable(false);
                break;
            }
            // seventh
            case R.id.b700:{
                if(flag) {
                    b[54].setText("O");
                    layout[5][0]++;
                }
                else {
                    b[54].setText("X");
                    layout[5][0]+=2;
                }
                b[54].setClickable(false);
                break;
            }
            case R.id.b701:{
                if(flag) {
                    b[55].setText("O");
                    layout[6][1]++;
                }
                else {
                    b[55].setText("X");
                    layout[6][1]+=2;
                }
                b[55].setClickable(false);
                break;
            }
            case R.id.b702:{
                if(flag) {
                    b[56].setText("O");
                    layout[6][2]++;
                }
                else {
                    b[56].setText("X");
                    layout[6][2]+=2;
                }
                b[56].setClickable(false);
                break;
            }
            case R.id.b710:{
                if(flag) {
                    b[57].setText("O");
                    layout[6][3]++;
                }
                else {
                    b[57].setText("X");
                    layout[6][3]+=2;
                }
                b[57].setClickable(false);
                break;
            }
            case R.id.b711:{
                if(flag) {
                    b[58].setText("O");
                    layout[6][4]++;
                }
                else {
                    b[58].setText("X");
                    layout[6][4]+=2;
                }
                b[58].setClickable(false);
                break;
            }
            case R.id.b712:{
                if(flag) {
                    b[59].setText("O");
                    layout[6][5]++;
                }
                else {
                    b[59].setText("X");
                    layout[6][5]+=2;
                }
                b[59].setClickable(false);
                break;
            }
            case R.id.b720:{
                if(flag) {
                    b[60].setText("O");
                    layout[6][6]++;
                }
                else {
                    b[60].setText("X");
                    layout[6][6]+=2;
                }
                b[60].setClickable(false);
                break;
            }
            case R.id.b721:{
                if(flag) {
                    b[61].setText("O");
                    layout[6][7]++;
                }
                else {
                    b[61].setText("X");
                    layout[6][7]+=2;
                }
                b[61].setClickable(false);
                break;
            }
            case R.id.b722:{
                if(flag) {
                    b[62].setText("O");
                    layout[6][8]++;
                }
                else {
                    b[62].setText("X");
                    layout[6][8]+=2;
                }
                b[62].setClickable(false);
                break;
            }
            // eight
            case R.id.b800:{
                if(flag) {
                    b[63].setText("O");
                    layout[7][0]++;
                }
                else {
                    b[63].setText("X");
                    layout[7][0]+=2;
                }
                b[63].setClickable(false);
                break;
            }
            case R.id.b801:{
                if(flag) {
                    b[64].setText("O");
                    layout[7][1]++;
                }
                else {
                    b[64].setText("X");
                    layout[7][1]+=2;
                }
                b[64].setClickable(false);
                break;
            }
            case R.id.b802:{
                if(flag) {
                    b[65].setText("O");
                    layout[7][2]++;
                }
                else {
                    b[65].setText("X");
                    layout[7][2]+=2;
                }
                b[65].setClickable(false);
                break;
            }
            case R.id.b810:{
                if(flag) {
                    b[66].setText("O");
                    layout[7][3]++;
                }
                else {
                    b[66].setText("X");
                    layout[7][3]+=2;
                }
                b[66].setClickable(false);
                break;
            }
            case R.id.b811:{
                if(flag) {
                    b[67].setText("O");
                    layout[7][4]++;
                }
                else {
                    b[67].setText("X");
                    layout[7][4]+=2;
                }
                b[67].setClickable(false);
                break;
            }
            case R.id.b812:{
                if(flag) {
                    b[68].setText("O");
                    layout[7][5]++;
                }
                else {
                    b[68].setText("X");
                    layout[7][5]+=2;
                }
                b[68].setClickable(false);
                break;
            }
            case R.id.b820:{
                if(flag) {
                    b[69].setText("O");
                    layout[7][6]++;
                }
                else {
                    b[69].setText("X");
                    layout[7][6]+=2;
                }
                b[69].setClickable(false);
                break;
            }
            case R.id.b821:{
                if(flag) {
                    b[70].setText("O");
                    layout[7][7]++;
                }
                else {
                    b[70].setText("X");
                    layout[7][7]+=2;
                }
                b[70].setClickable(false);
                break;
            }
            case R.id.b822:{
                if(flag) {
                    b[71].setText("O");
                    layout[7][8]++;
                }
                else {
                    b[71].setText("X");
                    layout[7][8]+=2;
                }
                b[71].setClickable(false);
                break;
            }
            // nine
            case R.id.b900:{
                if(flag) {
                    b[72].setText("O");
                    layout[8][0]++;
                }
                else {
                    b[72].setText("X");
                    layout[8][0]+=2;
                }
                b[72].setClickable(false);
                break;
            }
            case R.id.b901:{
                if(flag) {
                    b[73].setText("O");
                    layout[8][1]++;
                }
                else {
                    b[73].setText("X");
                    layout[8][1]+=2;
                }
                b[73].setClickable(false);
                break;
            }
            case R.id.b902:{
                if(flag) {
                    b[74].setText("O");
                    layout[8][2]++;
                }
                else {
                    b[74].setText("X");
                    layout[8][2]+=2;
                }
                b[74].setClickable(false);
                break;
            }
            case R.id.b910:{
                if(flag) {
                    b[75].setText("O");
                    layout[8][3]++;
                }
                else {
                    b[75].setText("X");
                    layout[8][3]+=2;
                }
                b[75].setClickable(false);
                break;
            }
            case R.id.b911:{
                if(flag) {
                    b[76].setText("O");
                    layout[8][4]++;
                }
                else {
                    b[76].setText("X");
                    layout[8][4]+=2;
                }
                b[76].setClickable(false);
                break;
            }
            case R.id.b912:{
                if(flag) {
                    b[77].setText("O");
                    layout[8][5]++;
                }
                else {
                    b[77].setText("X");
                    layout[8][5]+=2;
                }
                b[77].setClickable(false);
                break;
            }
            case R.id.b920:{
                if(flag) {
                    b[78].setText("O");
                    layout[8][6]++;
                }
                else {
                    b[78].setText("X");
                    layout[8][6]+=2;
                }
                b[78].setClickable(false);
                break;
            }
            case R.id.b921:{
                if(flag) {
                    b[79].setText("O");
                    layout[8][7]++;
                }
                else {
                    b[79].setText("X");
                    layout[8][7]+=2;
                }
                b[79].setClickable(false);
                break;
            }
            case R.id.b922:{
                if(flag) {
                    b[80].setText("O");
                    layout[8][8]++;
                }
                else {
                    b[80].setText("X");
                    layout[8][8]+=2;
                }
                b[80].setClickable(false);
                break;
            }
        }
    }

    private void setListeners(){
        for(Button btn: b)
            btn.setOnClickListener(this);
        undo.setOnClickListener(this);
    }

    private void init(){
        undo = findViewById(R.id.undo);
        b[0] = findViewById(R.id.b100);
        b[1] = findViewById(R.id.b101);
        b[2] = findViewById(R.id.b102);
        b[3] = findViewById(R.id.b110);
        b[4] = findViewById(R.id.b111);
        b[5] = findViewById(R.id.b112);
        b[6] = findViewById(R.id.b120);
        b[7] = findViewById(R.id.b121);
        b[8] = findViewById(R.id.b122);
        b[9] = findViewById(R.id.b200);
        b[10] = findViewById(R.id.b201);
        b[11] = findViewById(R.id.b202);
        b[12] = findViewById(R.id.b210);
        b[13] = findViewById(R.id.b211);
        b[14] = findViewById(R.id.b212);
        b[15] = findViewById(R.id.b220);
        b[16] = findViewById(R.id.b221);
        b[17] = findViewById(R.id.b222);
        b[18] = findViewById(R.id.b300);
        b[19] = findViewById(R.id.b301);
        b[20] = findViewById(R.id.b302);
        b[21] = findViewById(R.id.b310);
        b[22] = findViewById(R.id.b311);
        b[23] = findViewById(R.id.b312);
        b[24] = findViewById(R.id.b320);
        b[25] = findViewById(R.id.b321);
        b[26] = findViewById(R.id.b322);
        b[27] = findViewById(R.id.b400);
        b[28] = findViewById(R.id.b401);
        b[29] = findViewById(R.id.b402);
        b[30] = findViewById(R.id.b410);
        b[31] = findViewById(R.id.b411);
        b[32] = findViewById(R.id.b412);
        b[33] = findViewById(R.id.b420);
        b[34] = findViewById(R.id.b421);
        b[35] = findViewById(R.id.b422);
        b[36] = findViewById(R.id.b500);
        b[37] = findViewById(R.id.b501);
        b[38] = findViewById(R.id.b502);
        b[39] = findViewById(R.id.b510);
        b[40] = findViewById(R.id.b511);
        b[41] = findViewById(R.id.b512);
        b[42] = findViewById(R.id.b520);
        b[43] = findViewById(R.id.b521);
        b[44] = findViewById(R.id.b522);
        b[45] = findViewById(R.id.b600);
        b[46] = findViewById(R.id.b601);
        b[47] = findViewById(R.id.b602);
        b[48] = findViewById(R.id.b610);
        b[49] = findViewById(R.id.b611);
        b[50] = findViewById(R.id.b612);
        b[51] = findViewById(R.id.b620);
        b[52] = findViewById(R.id.b621);
        b[53] = findViewById(R.id.b622);
        b[54] = findViewById(R.id.b700);
        b[55] = findViewById(R.id.b701);
        b[56] = findViewById(R.id.b702);
        b[57] = findViewById(R.id.b710);
        b[58] = findViewById(R.id.b711);
        b[59] = findViewById(R.id.b712);
        b[60] = findViewById(R.id.b720);
        b[61] = findViewById(R.id.b721);
        b[62] = findViewById(R.id.b722);
        b[63] = findViewById(R.id.b800);
        b[64] = findViewById(R.id.b801);
        b[65] = findViewById(R.id.b802);
        b[66] = findViewById(R.id.b810);
        b[67] = findViewById(R.id.b811);
        b[68] = findViewById(R.id.b812);
        b[69] = findViewById(R.id.b820);
        b[70] = findViewById(R.id.b821);
        b[71] = findViewById(R.id.b822);
        b[72] = findViewById(R.id.b900);
        b[73] = findViewById(R.id.b901);
        b[74] = findViewById(R.id.b902);
        b[75] = findViewById(R.id.b910);
        b[76] = findViewById(R.id.b911);
        b[77] = findViewById(R.id.b912);
        b[78] = findViewById(R.id.b920);
        b[79] = findViewById(R.id.b921);
        b[80] = findViewById(R.id.b922);
    }
}
