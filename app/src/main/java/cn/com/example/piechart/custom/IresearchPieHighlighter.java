package cn.com.example.piechart.custom;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieRadarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/**
 * Created By: chenbiao
 * Date: 2018-03-06
 * Time: 11:25
 */
public class IresearchPieHighlighter extends PieRadarHighlighter<IresearchPieChart> {

    public IresearchPieHighlighter(IresearchPieChart chart) {
        super(chart);
    }

    @Override
    protected Highlight getClosestHighlight(int index, float x, float y) {

        IPieDataSet set = mChart.getData().getDataSet();

        final Entry entry = set.getEntryForIndex(index);

        return new Highlight(index, entry.getY(), x, y, 0, set.getAxisDependency());
    }
}


