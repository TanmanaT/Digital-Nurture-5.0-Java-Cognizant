import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-notification',
  imports: [CommonModule],
  providers: [NotificationService], // Component-level provider
  templateUrl: './notification.component.html',
  styleUrl: './notification.component.css',
})
export class Notification implements OnInit {
  // Component-level providers create a new instance of the service specifically for this component 
  // and its children. This is useful when we need isolated state per component instance 
  // (e.g. separate widgets that should not leak state into each other).
  constructor(public notificationService: NotificationService) {}

  ngOnInit(): void {
    this.notificationService.addMessage('Notification panel loaded.');
  }

  sendAlert(): void {
    const alerts = [
      'New homework assignment uploaded for Angular.',
      'Reminder: State Management quiz tomorrow.',
      'System maintenance scheduled for Sunday at 2 AM.',
      'You successfully enrolled in a new course!'
    ];
    const randomMsg = alerts[Math.floor(Math.random() * alerts.length)];
    this.notificationService.addMessage(randomMsg);
  }
}
