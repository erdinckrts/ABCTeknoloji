Feature: Hesap Makinesi Modul Testleri

  @1
  Scenario: SENARYO01 %5 Faiz Orani Ile 100 TL'lik Yatirimin 1 Yil Sonundaki Degerini Hesaplama
    Given Calculator Sayfasi Acilir
    Given Yatirim tutari 100 ve faiz orani yuzde 5 olarak verilir
    And Faiz orani yil(1) ile carpilir
    Then Sonucun 0.05 TL geldigi gorulur
    And Sonuc bir ile toplanir
    Then Sonucun 1.05 TL geldigi gorulur
    And Sonuc yatirim tutari ile carpilir
    Then Sonucun 105 TL geldigi gorulur

  @SN2
  Scenario Outline: SENARYO02 Aylik gelir gider degerleri ile tasarruf miktari hesaplama
    Given Open Calculator butonuna tiklanir
    Given Kullanici <gelir> TL gelir ve <gider> TL gider girisi yapar
    And Gelir degerinden gider degeri cikarilir
    Then Sonuc <tasarruf> degerine esit olmalidir


    Examples:
      | gelir | gider | tasarruf |
      | 1000  | 800   | 200           |
      | 1000  | 1000  | 0             |
      | 1000  | 1200  | -200          |
      | 2000  | 1000  | 1000          |
      | 1500  | 500   | 1000          |
      | 500   | 500   | 0             |


  @4
  Scenario: SENARYO04 %3 Faiz Orani Ile 500 TL'lik Yatirimin 0.5 Yil Sonundaki Degerini Hesaplama
    Given Calculator Sayfasi Acilir
    Given Yatirim tutari 500 ve faiz orani yuzde 3 olarak verilir
    And Faiz orani yil(0.5) ile carpilir
    Then Sonucun 0.015 TL geldigi gorulur
    And Sonuc bir ile toplanir
    Then Sonucun 1.015 TL geldigi gorulur
    And Sonuc yatirim tutari ile carpilir
    Then Sonucun 507,5 TL geldigi gorulur



