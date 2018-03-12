package cn.com.example.piechart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import cn.com.example.piechart.custom.IresearchPieChart;

public class MainActivity extends AppCompatActivity {

    private IresearchPieChart mPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPieChart = (IresearchPieChart) findViewById(R.id.PieChart);

        //mobile_pie_chart.setDrawEntryLabels(false)  //设置x值不显示
        mPieChart.setEntryLabelTextSize(10f);
        mPieChart.setEntryLabelColor(Color.WHITE);
        mPieChart.getLegend().setEnabled(false);//隐藏默认图列
        mPieChart.getDescription().setEnabled(false);//隐藏描述文字
        mPieChart.setTransparentCircleRadius(50f);// 半透明圈半径
        mPieChart.setHoleRadius(45f);   // 中心圈半径
        mPieChart.setExtraOffsets(30f, 20f, 30f, 20f);
        // mPieChart.setRotationEnabled(false);//禁止触摸旋转
        // mobile_pie_chart.setTouchEnabled(false)//禁止触摸

        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(10.23f, "小明"));
        entries.add(new PieEntry(16.36f, "小花"));
        entries.add(new PieEntry(22.32f, "小张"));
        entries.add(new PieEntry(5.63f, "小陈"));
        entries.add(new PieEntry(12.45f, "小李"));
        entries.add(new PieEntry(30.4f, "小刘"));
        setData(entries);

    }


    public void setData(ArrayList<PieEntry> entries) {
        PieDataSet dataSet = new PieDataSet(entries, "Quarterly Revenue 2018");
        dataSet.setSliceSpace(2f); //设置图块之间的间隔
        dataSet.setSelectionShift(5f); //设置选中突出的距离
        //数据和颜色
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#B2D233"));
        colors.add(Color.parseColor("#8DCB3A"));
        colors.add(Color.parseColor("#5FB738"));
        colors.add(Color.parseColor("#1AC7F3"));
        colors.add(Color.parseColor("#0096D2"));
        colors.add(Color.parseColor("#FFCF00"));
        dataSet.setColors(colors);

        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setValueLinePart1Length(0.5f); //设置第一根指示线条的长度
        dataSet.setValueLinePart2Length(0.2f); //设置第二根指示线条的长度
        dataSet.setValueLineColor(-0x1000000); //设置指示线条颜色,必须设置成这样，才能和饼图区域颜色一致
        dataSet.setValueLinePart1OffsetPercentage(100f); //指示线距离圆边缘的距离  0~100F

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());  //数据的百分比格式
        data.setValueTextSize(12f);         //数据的字体大小
        data.setValueTextColor(Color.WHITE);
        mPieChart.animateXY(1400, 1400);
        mPieChart.setData(data);

        mPieChart.invalidate();
    }
}
