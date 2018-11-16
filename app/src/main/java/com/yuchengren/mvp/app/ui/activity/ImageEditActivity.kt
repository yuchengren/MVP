package com.yuchengren.mvp.app.ui.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import com.yuchengren.mvp.R

import com.yuchengren.mvp.app.ui.view.imageedit.GraffitiPath
import com.yuchengren.mvp.util.ToastHelper
import kotlinx.android.synthetic.main.activity_image_edit.*
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

/**
 * Created by yuchengren on 2018/11/16.
 */
class ImageEditActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_edit)
        imageEditView.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.port))
        imageEditView.setPaths(GraffitiPath.parseSVGStringToPath("M54,200L54,200L54,202L55,201L55,202L55,203L55,205L55,206L55,208L55,211L55,213L55,216L55,219L55,223L55,226L55,230L55,234L55,239L56,244L56,248L57,252L57,255L58,259L58,262L58,265L59,269L59,272L59,275L59,277L59,279L59,281L59,284L60,286L61,288L61,292L62,295L62,298L62,302L62,305L62,310L62,314L62,318L62,323L62,326L62,329L62,333L61,336L60,338L60,340L60,342L59,345L59,348L58,350L59,353L58,356L58,360L58,363L58,366L58,370L57,373L57,377L57,379L57,383L57,387L56,390L56,394L56,397L56,400L56,404L56,407L55,409L55,412L55,415L55,417L55,421L55,424L55,428L55,432L55,436L55,441L55,445L55,449L55,454L55,456L55,460L55,463L55,466L55,468L55,470L55,472L55,473L55,474L55,475L55,476L55,478L55,480L55,481L55,484L55,486L55,488L55,490L55,493L56,495L57,499L59,503L59,508L59,511L59,515L59,518L59,521L59,525L59,528L59,531L59,534L59,536L59,538L59,538L59,540L59,541L59,542L59,542L59,542L59,543L59,544L59,546L59,546L59,548L59,549L59,550L59,551L59,552L59,554L59,554L59,557L59,559L59,562L60,566L60,569L60,572L61,576L61,578L61,582L61,584L62,587L62,589L62,591L62,593L62,595L62,598L62,600L62,602L63,603L63,605L63,606L63,609L63,611L64,613L64,615L65,618L65,620L65,622L65,625L65,627L65,629L66,631L66,634L66,637L66,639L66,641L66,643L66,645L66,647L66,650L66,652L66,654L66,655L66,657L66,659L66,660L66,661L66,663L66,664L66,665L66,666L66,669L66,671L67,673L67,676L69,678L69,681L70,684L70,687L71,691L72,696L72,700L73,704L74,709L74,714L74,719L74,723L75,727L75,731L76,734L76,738L76,740L76,744L76,746L76,749L76,751L76,753L77,754L77,757L77,760L77,763L77,766L77,770L77,772L77,774L77,776L77,780L77,783L77,786L77,789L76,791L76,793L76,795L75,797L75,800L74,803L74,805L74,808L74,810L73,813L73,816L71,818L72,821L72,824L71,827L71,831L71,833L70,837L70,840L69,843L69,847L69,850L69,853L69,858L69,863L69,867L69,871L69,875L69,878L69,881L69,885L69,888L69,891L69,895L69,900L69,904L69,908L69,912L69,915L69,919L69,923L69,928L69,932L69,937L70,942L70,946L70,952L70,957L71,961L71,967L72,972L72,977L72,981L72,987L72,992L72,998L72,1003L72,1008L72,1013L72,1019L72,1023L72,1028L72,1033L72,1039L72,1043L72,1048L72,1052L72,1056L72,1059L72,1063L72,1067L72,1070L72,1074L72,1078L71,1081L70,1085L70,1087L69,1091L69,1094L69,1098L69,1102L69,1106L69,1111L69,1115L69,1120L69,1124L69,1129L69,1135L69,1142L69,1149L69,1155L69,1162L69,1168L70,1176L70,1183L72,1190L72,1198L72,1205L72,1213L72,1221L72,1228L72,1235L73,1242L74,1248L74,1254L75,1260L75,1266L76,1271L77,1277L77,1282L77,1288L77,1294L77,1299L77,1306L78,1312L79,1318L79,1323L79,1329L79,1334L79,1339L79,1343L79,1348L78,1353L78,1357L76,1360L75,1364L75,1367L74,1370L74,1374L72,1377L73,1380L73,1384L73,1388L73,1393L73,1398L73,1402L73,1406L73,1411L73,1415L73,1420L73,1425L73,1431L73,1437L73,1443L73,1449L73,1456L73,1463L73,1469L73,1476L73,1483L73,1490L73,1496L73,1503L73,1510L73,1516L73,1523L73,1531L73,1537L73,1544L73,1549L72,1555L72,1560L71,1566L69,1571L69,1575L68,1580L68,1584L67,1587L67,1590L67,1593L67,1597L67,1599L67,1603L67,1605L67,1609L67,1612L67,1615L68,1619L69,1622L70,1626L70,1631L71,1635L71,1639L71,1643L71,1647L71,1650L71,1653L71,1656L71,1658L71,1660L71,1662L71,1665L71,1667L71,1670L71,1672L72,1677L72,1681L73,1687L74,1693L75,1698L76,1706L77,1712L77,1719L78,1725L79,1732L80,1739L82,1745L82,1752L83,1757L83,1763L84,1767L84,1772L84,1777L84,1781L84,1784L84,1787L84,1790L84,1794L84,1797L84,1800L84,1804L82,1807L81,1810L81,1815L79,1820L79,1824L78,1828L78,1831L78,1835L78,1837L78,1840L78,1842L78,1844L78,1845L79,1846L80,1847L80,1849L80,1852L80,1852L81,1855L81,1856L81,1857L82,1858L82,1859L82,1861L82,1862L82,1863L82,1864L82,1865L84,1866L85,1868L87,1870L90,1872L94,1875L99,1878L105,1879L112,1881L120,1882L129,1883L138,1884L148,1883L159,1883L172,1883L186,1883L199,1883L212,1883L224,1883L235,1882L246,1881L257,1879L268,1877L280,1874L289,1872L299,1870L307,1866L316,1864L325,1861L334,1858L343,1855L351,1853L359,1850L367,1848L374,1847L382,1846L390,1844L398,1844L406,1844L414,1844L421,1844L429,1844L436,1844L443,1844L450,1844L457,1844L463,1844L470,1845L477,1847L484,1848L491,1848L497,1850L504,1851L512,1853L519,1855L527,1856L535,1858L542,1859L550,1860L557,1861L565,1861L571,1861L577,1861L583,1"))
        btn_test1.setOnClickListener { imageEditView.clear() }
        btn_test2.setOnClickListener { imageEditView.undo() }
        btn_test3.setOnClickListener {
            val bitmap = imageEditView.save()
            val file = File(Environment.getExternalStorageDirectory(), System.currentTimeMillis().toString() + ".jpg")
            if (!file.parentFile.exists()) {
                file.parentFile.mkdirs() // 创建文件夹
            }
            try {
                val bos = BufferedOutputStream(
                        FileOutputStream(file))
                bitmap!!.compress(Bitmap.CompressFormat.JPEG, 100, bos) // 向缓冲区之中压缩图片
                bos.flush()
                bos.close()
            } catch (e: Exception) {
            }
            ToastHelper.show("保存完成")
        }

    }
}