## Module 1
REFLEKSI 1

-prinsip clean code : nama variabel simple dan jelas, fungsi yang dibuat tidak panjang dan jelas sehingga bisa dibaca dan dipahami tanpa perlu comment
-praktek security code : mengimplementasikan metode http yang sesuai
-kesusahan selama mengerjakan : kesusahan yang dialami adalah saat ingin menghapus delete nya menggunakan metode get yang seharusnya menggunakan post

REFLEKSI 2
1. percaya diri dan yakin kode yg ditulis berfungsi dengan baik. jumlah unit test buat satu kelas bisa beda-beda tergantung kompleksitasnya, mungkin setidaknya ada satu test case buat tiap metode. code coverage 100% bukan berarti tidak ada bug sama sekali, hanya mengartikan setiap baris kode dijalankan


## Module 2
You have implemented a CI/CD process that automatically runs the test suites, analyzes code quality, and deploys to a PaaS. Try to answer the following questions in order to reflect on your attempt completing the tutorial and exercise.
1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
- Masalah pertama `This utility class has a non-private constructor` yang mengindikasikan class constructor tidak bersifat private.
- Masalah kedua `Avoid the use of value annotations when its the only element` yang artinya tidak menggunakan `value` dalam annotation jika salah satu elemennya.
- Masalah ketiga `RUN chmod +x gradlew` harus menjalankan itu, jika tidak, gradlew tidak akan execute.
2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!
- CI (Continuous Integration), CI mengatur kode secara teratur ke dalam repository bersama dan menjalankan tes secara otomatis untuk mendeteksi error dengan cepat.
- CD (Continuous Deployment), CD melewati CI dengan cara otomatis menerapkan perubahan kode ke production setelah lulus uji kode. Jika CD dapat melalui tahapan pengujian, staging, dan produksi, serta memberikan perubahan kode dengan campur tangan manual yang minimal, maka itu mencerminkan implementasi CD yang kuat.


## Module 3
1) Explain what principles you apply to your project!
   - SRP: Memisahkan `CarController` dari `ProductController` untuk fokus pada Car saja, yang memudahkan untuk development
   - LSP: Menghindari inheritance langsung dari `ProductController` ke `CarController`, menegaskan subclass dapat menggantikan superclass tanpa mengubah fungsionalitas.
   - DIP dan OCP: Menggunakan abstract `CarService` daripada implementasi `CarServiceImpl`, memudahkan penggantian dan penambahan komponen tanpa mengubah kode yang ada.
   - ISP: Memastikan bahwa setiap interface fokus pada satu set, menghindari ketergantungan pada fungsi yang tidak digunakan.
2) Explain the advantages of applying SOLID principles to your project with examples.
   - OCP dan DIP: Mempermudah penambahan dan modifikasi komponen tanpa mempengaruhi komponen lain, mengurangi risiko bug dan meningkatkan kemudahan testing.
   - SRP: Meningkatkan kejelasan dan development kode, memudahkan pemahaman dan testing, serta mengurangi dampak perubahan.
   - LSP dan ISP: Menyediakan fleksibilitas dan kemudahan dalam penggantian atau penambahan komponen dengan jelas dan terbatas.
3) Explain the disadvantages of not applying SOLID principles to your project with examples.
   - Tanpa OCP dan DIP: Kode menjadi kaku dan sulit untuk diperbarui atau dites, dengan perubahan kecil berpotensi memerlukan penyesuaian besar.
   - Tanpa SRP: Kode menjadi rumit dan sulit untuk development, dengan perubahan pada satu bagian berpotensi mempengaruhi banyak bagian lain.
   - Tanpa LSP dan ISP: Kurangnya fleksibilitas dan dependensi tinggi antarkomponen, membuat sulit menambah atau mengubah fitur tanpa revisi.