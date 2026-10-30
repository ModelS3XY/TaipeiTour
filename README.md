# TaipeiTour — Taipei Attractions Guide (Android)

An Android app that lists Taipei tourist attractions from the Taipei City Government's open travel API, with a photo gallery and details for each spot, in 9 languages.

<!-- Add 2–3 screenshots here: the attraction list, the detail page, and the language menu -->
<p>
  <img src="docs/list.png" width="240" />
  <img src="docs/detail.png" width="240" />
  <img src="docs/language.png" width="240" />
</p>

## Features

- Browse Taipei attractions in a scrolling list
- Detail page with a swipeable photo gallery, introduction, address, last-updated time and official link
- Switch content language from the menu: Traditional Chinese, Simplified Chinese, English, Japanese, Korean, Spanish, Indonesian, Thai and Vietnamese. The list reloads in the chosen language.

## Tech stack

| Area | Choice |
| --- | --- |
| Language | Kotlin |
| UI | XML layouts, ViewBinding, RecyclerView, ViewPager2 |
| Navigation | Jetpack Navigation (single Activity, two Fragments) |
| Architecture | MVVM, shared `activityViewModels` between Fragments |
| Async / state | Kotlin Coroutines, LiveData |
| Networking | OkHttp, Gson |

## Architecture

```
MainActivity ── language menu
   ├── HomeFragment ── attraction list
   └── DetailFragment ── gallery + details
          │  both observe
          ▼
     SpotViewModel (shared) ── fetches spots, holds selected spot and language
          │
          ▼
     Taipei Travel Open API
```

Both Fragments share one ViewModel scoped to the Activity. Tapping a spot sets `selectedSpot`; the detail page observes it, so no data is passed through navigation arguments.

## Run it

1. Clone the repo and open it in Android Studio.
2. Run on a device or emulator.

No API key is needed.

## Data source

[Taipei Travel Open API](https://www.travel.taipei/open-api/swagger/ui/index)
