import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { PagesComponent } from './pages.component';

const routes: Routes = [
  {
    path: '',
    component: PagesComponent,
    children: [
      {
        path: 'admin',
        loadChildren: () => import('./admin/admin.module').then((m) => m.AdminModule),
      },
      {
        path: 'user-center',
        loadChildren: () => import('./user-center/user-center.module').then((m) => m.UserCenterModule),
      },
      {
        path: 'stdata',
        loadChildren: () => import('./stdata/stdata.module').then((m) => m.StdataModule),
      },
      {
        path: 'datadev',
        loadChildren: () => import('./datadev/datadev.module').then((m) => m.DatadevModule),
      },
      {
        path: 'studio',
        loadChildren: () => import('./studio/studio.module').then((m) => m.StudioModule),
      },
      {
        path: '',
        redirectTo: 'datadev',
        pathMatch: 'full',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {}
