package com.nutriwise.universe.ui.learning

import android.graphics.drawable.Drawable
import android.provider.Telephony.Sms.Draft
import com.nutriwise.universe.R

data class LearningData(
    val id: Int,
    val judul: String,
    val image: Int,
    val deskripsi: String
)

object DummyDataLearning {
    fun getLearningData(): List<LearningData> {
        return listOf(
            LearningData(
                id = 1,
                judul = "Rahasia Mengatasi Stunting di Masa Emas Anak",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    Tahukah Anda bahwa 1.000 hari pertama kehidupan adalah masa emas anak yang menentukan tumbuh kembangnya? 
                    Stunting, atau kondisi gagal tumbuh akibat kekurangan gizi kronis, adalah ancaman serius pada periode ini. 
                    Anak yang mengalami stunting tidak hanya memiliki tubuh lebih pendek dibandingkan anak seusianya, tetapi juga berisiko mengalami gangguan kognitif, kesehatan, dan produktivitas di masa dewasa.
                    
                    Penanganan stunting dimulai dari pola makan ibu hamil yang sehat, pemberian ASI eksklusif, serta makanan pendamping ASI yang bergizi. 
                    Tidak kalah penting, sanitasi yang baik dan akses ke air bersih juga memengaruhi penyerapan nutrisi pada anak. Mari bersama-sama melawan stunting demi masa depan generasi kita!
                """.trimIndent()
            ),
            LearningData(
                id = 2,
                judul = "10 Mitos Tentang Stunting yang Perlu Anda Ketahui",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    Banyak orang tua yang salah paham tentang stunting karena berbagai mitos yang beredar. Beberapa percaya bahwa stunting hanya masalah genetik atau tidak dapat diubah setelah terjadi. 
                    Faktanya, meskipun faktor genetik dapat memengaruhi tinggi badan, stunting lebih sering disebabkan oleh kekurangan gizi dan infeksi berulang.
                    
                    Mitos lain yang sering terdengar adalah bahwa stunting hanya berdampak pada tinggi badan. Padahal, dampaknya jauh lebih luas, termasuk risiko kesehatan kronis seperti diabetes, 
                    hipertensi, dan kemampuan belajar yang rendah. Dengan membongkar mitos-mitos ini, Anda dapat mengambil langkah tepat untuk melindungi anak dari risiko stunting.
                """.trimIndent()
            ),
            LearningData(
                id = 3,
                judul = "Mengapa Stunting Jadi Masalah Serius di Indonesia?",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    Indonesia adalah salah satu negara dengan angka stunting tertinggi di dunia. Menurut data WHO, sekitar 27% anak di Indonesia mengalami stunting. 
                    Kondisi ini disebabkan oleh kombinasi berbagai faktor, mulai dari kurangnya edukasi gizi, rendahnya akses terhadap fasilitas kesehatan, hingga kemiskinan.
                    
                    Mengatasi stunting di Indonesia membutuhkan pendekatan holistik. Tidak hanya intervensi gizi, tetapi juga perbaikan sanitasi, penyuluhan kepada ibu hamil, 
                    dan peningkatan akses terhadap layanan kesehatan. Jika tidak ditangani, stunting dapat menurunkan kualitas sumber daya manusia dan memperlambat pembangunan nasional.
                """.trimIndent()
            ),
            LearningData(
                id = 4,
                judul = "Pola Asuh yang Salah: Kontributor Utama Stunting",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    Pola asuh memiliki pengaruh besar terhadap risiko stunting pada anak. Misalnya, pemberian makanan yang tidak sesuai usia, 
                    kurangnya pengetahuan orang tua tentang gizi, dan kebiasaan buruk seperti membiarkan anak mengonsumsi makanan instan yang minim nutrisi.
                    
                    Untuk mencegah stunting, penting bagi orang tua untuk memahami kebutuhan gizi anak sesuai usianya. Memberikan makanan alami, seperti sayuran, buah-buahan, 
                    protein hewani, dan susu, sangat disarankan. Selain itu, orang tua juga perlu memperhatikan kebersihan lingkungan dan kebiasaan mencuci tangan untuk menghindari infeksi.
                """.trimIndent()
            ),
            LearningData(
                id = 5,
                judul = "Inovasi Teknologi untuk Mengatasi Stunting",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    Teknologi telah membuka peluang baru dalam mengatasi masalah stunting. Dari aplikasi yang memberikan edukasi tentang pola makan sehat hingga alat deteksi dini stunting, 
                    inovasi teknologi membantu para orang tua dan tenaga medis untuk memberikan intervensi yang tepat.
                    
                    Contohnya, aplikasi berbasis AI dapat membantu orang tua memantau asupan gizi anak secara real-time. Selain itu, teknologi telemedicine memungkinkan keluarga 
                    yang tinggal di daerah terpencil mendapatkan akses konsultasi dengan dokter ahli gizi. Dengan menggabungkan teknologi dan kesadaran masyarakat, kita bisa mempercepat pengurangan angka stunting.
                """.trimIndent()
            ),
            LearningData(
                id = 6,
                judul = "Gizi Ibu Hamil: Kunci Pencegahan Stunting",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    Kondisi gizi ibu hamil sangat menentukan risiko stunting pada anak. Kekurangan zat gizi seperti protein, zat besi, asam folat, dan kalsium dapat menghambat 
                    perkembangan janin, meningkatkan risiko bayi lahir dengan berat badan rendah, dan berujung pada stunting.
                    
                    Ibu hamil disarankan untuk mengonsumsi makanan bergizi seimbang, termasuk sayuran hijau, daging, telur, susu, dan kacang-kacangan. 
                    Selain itu, pemeriksaan kehamilan secara rutin sangat penting untuk memastikan kesehatan ibu dan janin, serta mendeteksi dini risiko stunting.
                """.trimIndent()
            ),
            LearningData(
                id = 7,
                judul = "Mengenal Pentingnya ASI Eksklusif untuk Tumbuh Kembang Anak",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    ASI eksklusif selama enam bulan pertama kehidupan anak adalah langkah pertama dalam mencegah stunting. ASI mengandung semua nutrisi yang dibutuhkan bayi, 
                    termasuk antibodi untuk melawan infeksi. Setelah enam bulan, pemberian ASI dilanjutkan dengan makanan pendamping yang bergizi.
                    
                    Banyak ibu yang merasa khawatir dengan kualitas ASI mereka, padahal dengan pola makan sehat dan cukup istirahat, ASI sudah memenuhi kebutuhan bayi. 
                    Pemberian ASI eksklusif juga memperkuat ikatan emosional antara ibu dan anak, yang penting untuk perkembangan psikologis anak.
                """.trimIndent()
            ),
            LearningData(
                id = 8,
                judul = "Sanitasi Buruk: Musuh Tersembunyi dalam Melawan Stunting",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    Sanitasi buruk adalah salah satu penyebab utama stunting yang sering kali diabaikan. Infeksi cacing dan diare berulang akibat air yang tidak bersih 
                    dapat menghambat penyerapan nutrisi pada anak, meskipun mereka sudah mengonsumsi makanan bergizi.
                    
                    Pemerintah dan masyarakat perlu bekerja sama untuk meningkatkan akses ke air bersih, membangun fasilitas sanitasi yang memadai, dan mengedukasi 
                    pentingnya kebiasaan hidup bersih, seperti mencuci tangan dengan sabun. Dengan langkah ini, kita dapat mencegah stunting secara efektif.
                """.trimIndent()
            ),
            LearningData(
                id = 9,
                judul = "Generasi Bebas Stunting: Apa yang Bisa Kita Lakukan?",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    Membangun generasi bebas stunting memerlukan upaya kolektif dari berbagai pihak, termasuk pemerintah, tenaga kesehatan, orang tua, dan masyarakat. 
                    Edukasi gizi, pemberian makanan tambahan di sekolah, dan program sanitasi adalah beberapa langkah yang telah terbukti efektif.
                    
                    Anda juga dapat berkontribusi dengan menyebarkan informasi yang benar tentang stunting kepada orang-orang di sekitar Anda. Mari bersama-sama 
                    memastikan setiap anak Indonesia tumbuh sehat, cerdas, dan produktif.
                """.trimIndent()
            ),
            LearningData(
                id = 10,
                judul = "Stunting dan Pendidikan: Mengapa Keduanya Berkaitan?",
                image = R.drawable.image_item_learning_home_fragment,
                deskripsi = """
                    Stunting tidak hanya berdampak pada fisik anak, tetapi juga pada kemampuan belajarnya. Anak yang stunting cenderung memiliki IQ lebih rendah, 
                    kesulitan berkonsentrasi, dan prestasi akademik yang buruk. Hal ini berdampak langsung pada peluang mereka di dunia pendidikan dan karir di masa depan.
                    
                    Dengan mencegah stunting sejak dini, kita tidak hanya menyelamatkan satu generasi, tetapi juga membuka peluang bagi mereka untuk mendapatkan 
                    pendidikan yang layak dan masa depan yang cerah. Investasi dalam pencegahan stunting adalah investasi untuk masa depan bangsa.
                """.trimIndent()
            )
        )
    }
}
