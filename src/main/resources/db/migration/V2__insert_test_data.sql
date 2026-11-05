INSERT INTO companies (name, industry, location) VALUES
('株式会社テクノロジーラボ','IT・通信','東京都渋谷区'),
('グローバル・システムインテグレーション','システム開発','大阪市北区');

INSERT INTO jobs (company_id, title, salary, description) VALUES
(1,'Javaバックエンドエンジニア(未経験歓迎)','月給　25万円　〜　40万円','自社開発の求人マッチングサービスにおける、Java(Spring Boot)を使ったサーバーサイド開発をお任せします。Webアプリの基礎知識がある方大歓迎！'),
(1,'フロントエンドエンジニア','月給　28万円　〜　45万円','Vue.js または React を用いたWebアプリケーションの画面側開発です。デザイナーと連携して使いやすいUIを構築します。');

INSERT INTO jobs (company_id, title, salary, description) VALUES
(2,'社内業務システム開発エンジニア','月給 30万円　〜　50万円','大手クライアント向けの基幹システム構築プロジェクトです。Java、MySQLを用いた堅牢なシステム設計・開発に携わっていただきます。');