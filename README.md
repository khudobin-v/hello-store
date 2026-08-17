# Тестовое приложение личного магазина

Минимальное Android-приложение, на котором проверяется весь конвейер релизов.
Показывает свою версию — по ней видно, что обновление действительно встало.

## Релиз

```bash
# поднять versionCode и versionName в app/build.gradle.kts, закоммитить, запушить
./release.sh 1.1.0 "Что нового"
```

Дальше CI сам: собирает подписанный APK → создаёт GitHub Release →
обновляет `apps.json` в репозитории манифеста → приложение в магазине на
телефоне показывает «Обновить».

## Настройка

См. чек-лист в `release-kit/README.md` основного проекта. Кратко:

1. secrets `KEYSTORE_BASE64`, `KEYSTORE_PASSWORD`, `KEY_ALIAS`, `KEY_PASSWORD`,
   `MANIFEST_PAT` (проще всего `./tools/setup-app-repo.sh <владелец>/app-store-manifest`);
2. `MANIFEST_REPO` в `.github/workflows/release.yml`;
3. иконка витрины — `store/icon.png`.

## Локальная сборка

```bash
./gradlew assembleRelease   # без KEYSTORE_PATH соберётся неподписанный APK
```
