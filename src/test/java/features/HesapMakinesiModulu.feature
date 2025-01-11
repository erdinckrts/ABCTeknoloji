Feature: Hesap Makinesi Modul Testleri

  @1
  Scenario: SENARYO01 %5 Faiz Orani Ile 100 TL'lik Yatirimin 1 Yil Sonundaki Degerini Hesaplama
    Given Calculator Sayfasi Acilir
    Given Yatirim tutari 100 ve faiz oranı %5 olarak verilir
    And Faiz orani yil(1) ile carpilir
    Then Sonucun 0.05 geldigi gorulur
    And Sonuc bir ile toplanir
    Then Sonucun 1.05 geldigi gorulur
    And Sonuc yatirim tutari ile carpilir
    Then Sonucun 105 geldigi gorulur





