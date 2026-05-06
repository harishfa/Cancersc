# Cancersc - Skin Cancer Detection App

**Cancersc** adalah aplikasi Android berbasis Machine Learning yang dirancang untuk membantu deteksi dini potensi kanker kulit melalui analisis gambar lesi kulit. Dengan memanfaatkan model klasifikasi gambar yang berjalan langsung di perangkat (*on-device*), aplikasi ini memberikan hasil analisis berupa skor probabilitas secara cepat dan privat. Aplikasi ini bertujuan sebagai alat skrining awal untuk meningkatkan kesadaran kesehatan kulit sebelum melakukan konsultasi medis profesional.

Proyek ini merupakan submission dari **Bangkit Academy** untuk kelas **Bangkit: Belajar Penerapan Machine Learning untuk Android**.

## Preview
Berikut adalah tampilan antarmuka dari aplikasi Cancersc:

| Halaman Utama | Input Gambar | Preview Gambar |
| :---: | :---: | :---: |
| ![Halaman Utama](screenshot/Halaman%20Utama.jpg) | ![Input Gambar](screenshot/Input%20Gambar.jpg) | ![Preview Gambar](screenshot/Preview%20Gambar.jpg) |

| Hasil Analisis Gambar | Daftar Riwayat |
| :---: | :---: |
| ![Hasil Analisis](screenshot/Hasil%20Analisis%20Gambar.jpg) | ![Daftar Riwayat](screenshot/Daftar%20Riwayat%20Hasil%20Analisis.jpg) |

## Fitur
- **Deteksi Kanker Kulit**: Analisis gambar secara instan menggunakan model TensorFlow Lite yang berjalan secara lokal.
- **Image Cropping**: Fitur untuk memotong gambar agar fokus pada area lesi sebelum dianalisis menggunakan library UCrop.
- **Riwayat Analisis**: Penyimpanan otomatis hasil pemeriksaan ke database lokal menggunakan Room.
- **Berita Kesehatan**: Menampilkan informasi dan artikel terbaru mengenai kesehatan kulit yang bersumber dari News API.
- **Offline Processing**: Proses klasifikasi gambar dilakukan sepenuhnya di perangkat tanpa memerlukan koneksi internet untuk menjaga privasi dan kecepatan.

## Arsitektur dan Teknologi
Aplikasi ini dibangun dengan mengikuti standar pengembangan Android modern dan pola arsitektur yang bersih:
- **Arsitektur**: MVVM (Model-View-ViewModel).
- **Bahasa Pemrograman**: Kotlin.
- **Machine Learning**: TensorFlow Lite (Task Vision Library).
- **Database Lokal**: Room Persistence Library.
- **Networking**: Retrofit & Gson (untuk integrasi News API).
- **Pengolahan Gambar**: Glide (image loading) dan UCrop (image cropping).
- **View Binding**: Untuk interaksi komponen UI yang aman dan efisien.

## Cara Menjalankan Projek
Ikuti langkah-langkah berikut untuk menjalankan projek di lingkungan pengembangan Anda:

1. **Persyaratan**:
   - Android Studio (Flamingo atau lebih baru).
   - JDK 17.
   - Perangkat Android atau Emulator dengan Min SDK 24 (Android 7.0).

2. **Konfigurasi API Key**:
   Aplikasi memerlukan konfigurasi di file `local.properties` agar dapat dikompilasi:
   - Buka file `local.properties` di folder root projek.
   - Tambahkan baris berikut:
     ```properties
     API_KEY=masukkan_api_key_newsapi_anda
     BASE_URL=https://newsapi.org/v2/
     ```
   *Catatan: API Key bisa didapatkan secara gratis melalui [newsapi.org](https://newsapi.org/).*

3. **Build & Run**:
   - Clone repositori ini.
   - Buka projek melalui Android Studio.
   - Tunggu proses Gradle Sync selesai.
   - Klik tombol **Run** untuk menginstal aplikasi.

## Struktur Folder Utama
```text
app/src/main/java/com/dicoding/cancersc/
├── data/       # Data Layer: Repository, Local (Room), Remote (Retrofit)
├── di/         # Dependency Injection
├── helper/     # Helper classes (e.g., ImageClassifierHelper untuk TFLite)
├── util/       # Utility classes umum
└── view/       # UI Layer: Activities & ViewModels
    ├── history/# Fitur Riwayat Hasil Analisis
    ├── news/   # Fitur Berita Kesehatan
    └── result/ # Fitur Hasil Klasifikasi & Analisis
```

---
